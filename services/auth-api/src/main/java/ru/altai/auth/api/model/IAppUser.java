package ru.altai.auth.api.model;

import java.util.Set;

public interface IAppUser {

    String NAME_PARAM = "user";

    Long getId();
    String getUsername();
    String getPassword();
    Boolean getEnabled();
    Set<? extends IUserRole> getRoles();
    IProfile getProfile();

}
