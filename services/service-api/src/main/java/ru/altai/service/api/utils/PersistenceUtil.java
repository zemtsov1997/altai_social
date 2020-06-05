package ru.altai.service.api.utils;

public class PersistenceUtil {

    public static String[] convertStrWithPointsToArray(String value) {
        return value.split("\\.");
    }

}
