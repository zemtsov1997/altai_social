package ru.altai.auth.api.model;

import ru.altai.service.api.model.NameToDescription;
import ru.altai.service.api.model.NameToSystem;
import ru.altai.service.api.model.NameToView;

public interface IUserRole extends NameToSystem, NameToView, NameToDescription {

    Long getId();

}
