package org.keegsands.sportball.service;

import org.keegsands.sportball.model.Player;

import java.util.List;

public interface PlayerService extends SimpleService<Player> {

	List<Player> findByTeam(int teamId);
}
