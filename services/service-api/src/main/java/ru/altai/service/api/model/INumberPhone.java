package ru.altai.service.api.model;

public interface INumberPhone {

    default String getFullNumber() {
        return getCode()+getNumber();
    }

    Long getId();
    String getCode();
    String getNumber();

}
