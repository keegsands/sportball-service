package org.keegsands.sportball.dao;

import org.keegsands.sportball.model.Season;

import java.util.List;

public interface SeasonDAO extends SimpleDAO<Season> {
	List<Season> listStandingSeasons();
}
