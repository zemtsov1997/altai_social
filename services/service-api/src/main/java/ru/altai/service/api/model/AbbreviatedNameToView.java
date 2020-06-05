package ru.altai.service.api.model;

import org.springframework.context.i18n.LocaleContextHolder;
import ru.altai.service.api.utils.LocaleUtil;

import java.util.Locale;
import java.util.Map;

public interface AbbreviatedNameToView {

    default String getAbbreviatedNameToView() {
        String nameView = getAbbreviatedNamesToView().get(LocaleContextHolder.getLocale());
        if (nameView == null) nameView = getAbbreviatedNamesToView().get(LocaleUtil.getDefault());
        return nameView;
    }

    default String getAbbreviatedNameToView(Locale locale) {
        String nameView = getAbbreviatedNamesToView().get(locale);
        if (nameView == null) nameView = getAbbreviatedNamesToView().get(LocaleUtil.getDefault());
        return nameView;
    }

    Map<Locale, String> getAbbreviatedNamesToView();

}
