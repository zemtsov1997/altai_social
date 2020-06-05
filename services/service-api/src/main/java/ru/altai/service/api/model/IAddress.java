package ru.altai.service.api.model;

public interface IAddress {

    Long getId();
    Long getCountryId();
    Long getRegionId();
    Long getCityId();
    String getStreet();
    String getHouse();

}
