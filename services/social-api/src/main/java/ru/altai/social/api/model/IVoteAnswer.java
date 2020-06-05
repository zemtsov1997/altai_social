package ru.altai.social.api.model;

import ru.altai.service.api.model.name.INameSystem;
import ru.altai.service.api.model.name.INameView;

public interface IVoteAnswer {

    Long getId();

    INameSystem getNameSystem();

    INameView getNameView();

}
