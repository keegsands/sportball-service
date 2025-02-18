package org.keegsands.sportball.dao;

import org.keegsands.sportball.model.Campaign;

import java.util.List;

public interface CampaignDAO extends SimpleDAO<Campaign> {
	List<Campaign> findBySeason(final int seasonID);
}
