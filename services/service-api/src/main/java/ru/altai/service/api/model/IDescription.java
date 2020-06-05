package ru.altai.service.api.model;

import ru.altai.service.api.utils.DescriptionUtil;

public interface IDescription {

    default String validSettedText(String value) {
        Boolean bool = DescriptionUtil.isValidDescText(value);
        if (bool) {
            return value;
        } else {
            return null;
        }
    }

    Long getId();

}
