package ru.altai.service.api.utils;

public class Objects {

    public static boolean isNullOrEmpty(Object object) {
        return object == null || object.toString().isEmpty();
    }

}
