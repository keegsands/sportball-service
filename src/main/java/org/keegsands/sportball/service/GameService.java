package org.keegsands.sportball.service;

import org.keegsands.sportball.model.Game;

import java.util.List;

public interface GameService extends SimpleService<Game> {
	
	List<Game> findBySeason(final int seasonID);
	
	List<Game> listNextTenGames();

	List<Game> findByTeamAndSeason(final int teamID, final int seasonID);

	void updateScore(final int gameID, final int homeTeamRuns, final int awayTeamRuns, final boolean complete, final String status);
}
