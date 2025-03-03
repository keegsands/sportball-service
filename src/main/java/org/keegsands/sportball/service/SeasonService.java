package org.keegsands.sportball.service;

import org.keegsands.sportball.model.Season;
import org.keegsands.sportball.model.Standing;

import java.util.List;

public interface SeasonService extends SimpleService<Season> {

	/**
	 * Get the standings for the specified season
	 * 
	 * @param seasonID
	 * @return
	 */
	List<Standing> getStandings(int seasonID);
	
	List<Season> listStandingSeasons();

	Season getCurrentSeason();

	List<Season> getSeasons();
}
