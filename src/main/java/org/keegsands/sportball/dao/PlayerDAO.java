package org.keegsands.sportball.dao;

import org.keegsands.sportball.model.Player;

import java.util.List;

public interface PlayerDAO extends SimpleDAO<Player> {
	List<Player> findByTeam(final int teamId);
}
