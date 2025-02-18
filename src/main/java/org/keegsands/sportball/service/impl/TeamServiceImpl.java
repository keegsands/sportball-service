package org.keegsands.sportball.service.impl;

import org.keegsands.sportball.dao.TeamDAO;
import org.keegsands.sportball.model.Team;
import org.keegsands.sportball.service.TeamService;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl extends AbstractSimpleServiceImpl<Team, TeamDAO>
		implements TeamService {
	public void setTeamDAO(final TeamDAO teamDao) {
		super.setDAO(teamDao);
	}
}
