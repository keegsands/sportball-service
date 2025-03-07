package org.keegsands.sportball.service.impl;

import org.keegsands.sportball.model.Season;
import org.keegsands.sportball.dao.CampaignDAO;
import org.keegsands.sportball.dao.GameDAO;
import org.keegsands.sportball.dao.SeasonDAO;
import org.keegsands.sportball.repository.SeasonRepository;
import org.keegsands.sportball.model.*;
import org.keegsands.sportball.service.SeasonService;
import org.keegsands.sportball.util.BaseballUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SeasonServiceImpl extends AbstractSimpleServiceImpl<Season, SeasonDAO> implements SeasonService {
	private static final int CURRENT_SEASON = 18;
	private GameDAO gameDAO;
	private CampaignDAO campaignDAO;

	private SeasonRepository seasonRepository;

	public SeasonServiceImpl(final SeasonDAO seasonDAO, final GameDAO gameDAO, final CampaignDAO campaignDAO, final SeasonRepository seasonRepository){
		super.setDAO(seasonDAO);
		this.gameDAO = gameDAO;
		this.campaignDAO = campaignDAO;
		this.seasonRepository = seasonRepository;
	}

	@Override
	@Transactional
	public List<Standing> getStandings(int seasonID) {
		final List<Standing> standings;
		final List<Campaign> campaigns = campaignDAO.findBySeason(seasonID);
		standings = buildStandingsFromCampaigns(campaigns);
		
		return standings;
	}
	
	private void processStandings(final List<Standing> standings){
		if(standings.size() != 0){
			Collections.sort(standings);
			BaseballUtil.fixStandingsTieBreaker(standings);
	
			final Double firstPlaceWins = standings.get(0).getWins() + (.5 * standings.get(0).getTies());
			final int firstPlaceLosses = standings.get(0).getLosses();
			for (final Standing standing : standings) {
				final Double currentWins = standing.getWins() + (.5 * standing.getTies());
				standing.setGamesBack(BaseballUtil.calculateGamesBack(firstPlaceWins.floatValue(), firstPlaceLosses, currentWins.floatValue(), standing.getLosses()));
			}
		}
	}
	
	private List<Standing> buildStandingsFromCampaigns(List<Campaign> campaigns){
		final List<Standing> standings = new ArrayList<Standing>();
		final Map<Division, List<Standing>> divisionMap = new HashMap<Division, List<Standing>>();
		for (final Campaign campaign : campaigns) {
			final List<Game> games = gameDAO.findByTeamAndSeason(campaign.getTeam().getId(), campaign.getSeason().getId());
			// If there are games for the team for this season then create a new Standing object
			if(null != games && !games.isEmpty()){
				final Standing standing = new Standing();
				standing.setCampaign(campaign);
				standing.setTeam(campaign.getTeam());
				standing.setGames(games);
				standing.initData();
				final List<Standing> divisionStandings;
				if(!divisionMap.containsKey(campaign.getDivision())){
					divisionStandings = new ArrayList<Standing>();
					divisionMap.put(campaign.getDivision(), divisionStandings);	
				}else{
					divisionStandings = divisionMap.get(campaign.getDivision());
				}
				divisionStandings.add(standing);
			}
		}
		if(!divisionMap.isEmpty()){
			final List<Division> divisions = new ArrayList<Division>();
			for (Division division : divisionMap.keySet()) {
			    divisions.add(division);
			}
			Collections.sort(divisions);
			for(final Division division : divisions){
				final List<Standing> divisionStandings = divisionMap.get(division);
				processStandings(divisionStandings);
				standings.addAll(divisionStandings);
			}
		}
		return standings;
	}

	public List<Season> getSeasons(){
		return this.seasonRepository.findAll();
	}
	

	@Override
	@Transactional
	public List<Season> listStandingSeasons() {
		return getDAO().listStandingSeasons();
	}

	@Override
	@Transactional
	public Season getCurrentSeason() {
		return getDAO().getById(CURRENT_SEASON);
	}

}
