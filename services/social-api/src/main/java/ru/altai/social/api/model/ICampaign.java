package ru.altai.social.api.model;

import java.time.LocalDateTime;
import java.util.Set;

public interface ICampaign {

    Long getId();

    ICampaignStatus getCampaignStatus();

    LocalDateTime getDateCreate();
    LocalDateTime getDateStart();
    LocalDateTime getDateFinish();

    Set<? extends IVote> getVotes();

}
