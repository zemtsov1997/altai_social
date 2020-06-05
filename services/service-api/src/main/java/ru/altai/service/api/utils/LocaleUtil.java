package ru.altai.service.api.utils;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleUtil {

    public static final Locale LOCALE_RU = new Locale("ru", "RU");
    public static final Locale LOCALE_EN = Locale.ENGLISH;

    public static Locale getDefault(){
        return LocaleUtil.LOCALE_RU;
    }

    public static Locale[] getAll() {
        return new Locale[]{ LocaleUtil.LOCALE_RU, LocaleUtil.LOCALE_EN };
    }

}
