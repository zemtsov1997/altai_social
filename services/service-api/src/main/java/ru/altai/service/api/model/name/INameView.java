package ru.altai.service.api.model.name;

import java.util.Locale;
import java.util.Map;

public interface INameView extends IName {

    String getName(Locale locale);

    Map<Locale, String> getNames();

}
