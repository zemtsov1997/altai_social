package ru.altai.auth.service.entity;

import ru.altai.auth.api.model.IGender;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Entity
public class Gender implements IGender {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameToSystem;

    @ElementCollection
    private Map<Locale, String> namesToView = new HashMap<>();

    public Gender() { }

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
        Gender gender = (Gender) o;
        return Objects.equals(nameToSystem, gender.nameToSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToSystem);
    }
}
