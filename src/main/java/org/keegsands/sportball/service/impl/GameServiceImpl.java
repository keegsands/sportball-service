package org.keegsands.sportball.service.impl;

import org.keegsands.sportball.dao.GameDAO;
import org.keegsands.sportball.model.Game;
import org.keegsands.sportball.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl extends AbstractSimpleServiceImpl<Game, GameDAO> implements GameService {

	public GameServiceImpl(final GameDAO gameDAO) {
		super.setDAO(gameDAO);
	}

	@Override
	public List<Game> listNextTenGames() {
		return getDAO().listNextTenGames();
	}

	@Override
	public List<Game> findByTeamAndSeason(int teamID, int seasonID) {
		return getDAO().findByTeamAndSeason(teamID, seasonID);
	}

	@Override
	public void updateScore(final int gameID, final int homeTeamRuns, final int awayTeamRuns, final boolean complete, final String status) {
		getDAO().updateScore(gameID, homeTeamRuns, awayTeamRuns, complete, status);

	}

	@Override
	public List<Game> findBySeason(int seasonID) {
		return getDAO().findBySeason(seasonID);
	}

}
