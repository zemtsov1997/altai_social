package ru.altai.service.api.dto.name;

import ru.altai.service.api.model.name.INameView;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class NameViewDto implements INameView {

    private Map<Locale, String> namesView;

    public NameViewDto(Map<Locale, String> namesView) {
        this.namesView = namesView;
    }

    public NameViewDto() { }

    public NameViewDto(INameView nameView) {
        this.namesView = nameView.getNames();
    }

    @Override
    public String getName(Locale locale) {
        return namesView.get(locale);
    }

    @Override
    public Map<Locale, String> getNames() {
        return namesView;
    }
    public void setNamesView(Map<Locale, String> namesView) {
        this.namesView = namesView;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameViewDto that = (NameViewDto) o;
        return Objects.equals(namesView, that.namesView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namesView);
    }
}
