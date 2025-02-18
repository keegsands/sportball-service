package org.keegsands.sportball.service;

import org.keegsands.sportball.model.Campaign;

import java.util.List;

public interface CampaignService extends SimpleService<Campaign> {
	List<Campaign> findBySeason(final int seasonID);
}
