package ru.altai.social.api.model;

import java.util.Set;

public interface ICampaign {

    Long getId();

    ICampaignStatus getCampaignStatus();

    Set<? extends IVote> getVotes();

}
