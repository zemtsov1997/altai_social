package ru.altai.social.api.model;

public interface IArticle {

    Long getId();

    String getCaption();

    String getDescription();

    String getText();

    ICampaign getCampaign();

}
