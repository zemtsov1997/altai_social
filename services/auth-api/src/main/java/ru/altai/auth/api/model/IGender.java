package ru.altai.auth.api.model;

import ru.altai.service.api.model.NameToSystem;
import ru.altai.service.api.model.NameToView;

public interface IGender extends NameToSystem, NameToView {

    Long getId();

}
