package ru.altai.service.api.utils;

import ru.altai.service.api.UrlSeparator;

import java.util.Map;

public class UrlUtil {

    public static String convertParamsForGetRequest(Map<String, Object> urlParams) {
        UrlSeparator sp = new UrlSeparator();
        StringBuffer s = new StringBuffer();
        urlParams.entrySet().stream().forEach( entery -> {
            if (UrlUtil.validParam(entery.getValue().toString())) {
                s.append(sp.get() + entery.getKey() + "=" + entery.getValue());
            }
        });
        return s.toString();
    }

    public static Boolean validParam(String param) {
        return param != null && !param.isEmpty();
    }

}
