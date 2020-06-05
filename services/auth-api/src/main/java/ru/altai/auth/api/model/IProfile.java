package ru.altai.auth.api.model;

import ru.altai.service.api.model.INumberPhone;
import ru.altai.service.api.utils.TimeUtil;

import java.time.LocalDate;

public interface IProfile {

    String NAME_PARAM = "profile";

    default String getFullName() {
        return this.getLastName()+" "+this.getFirstName()+" "+this.getMiddleName();
    }

    default Integer getAge() {
        return TimeUtil.calAge(this.getDateBirthday(), null);
    }

    Long getId();
    String getLastName();
    String getFirstName();
    String getMiddleName();
    Long getGenderId();
    INumberPhone getNumberPhone();
    String getEmail();
    LocalDate getDateBirthday();
    Long getAvatarId();

}
