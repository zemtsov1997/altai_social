package ru.altai.social.api.model;

public interface IVote {

    Long getId();

    IVoteAnswer getAnswer();

    Long getUserId();

    Long getCampaignId();

}
