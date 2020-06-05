package ru.altai.auth.api.dto;

import ru.altai.auth.api.model.IGender;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class GenderDto implements IGender {

    private Long id;

    private String nameToSystem;

    private Map<Locale, String> namesToView = new HashMap<>();

    public GenderDto() { }

    public GenderDto(Long id, String nameToSystem, Map<Locale, String> namesToView) {
        this.id = id;
        this.nameToSystem = nameToSystem;
        this.namesToView = namesToView;
    }

    public GenderDto(IGender gender) {
        this.id = gender.getId();
        this.nameToSystem = gender.getNameToSystem();
        this.namesToView = gender.getNamesToView();
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNameToSystem() {
        return nameToSystem;
    }
    public void setNameToSystem(String nameToSystem) {
        this.nameToSystem = nameToSystem;
    }

    @Override
    public Map<Locale, String> getNamesToView() {
        return namesToView;
    }
    public void setNamesToView(Map<Locale, String> namesToView) {
        this.namesToView = namesToView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderDto gender = (GenderDto) o;
        return Objects.equals(nameToSystem, gender.nameToSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToSystem);
    }
}
