package ru.altai.auth.service.entity;

import ru.altai.auth.api.model.IUserRole;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Entity
public class UserRole implements IUserRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameToSystem;
    @ElementCollection
    private Map<Locale, String> namesToView = new HashMap<>();
    @ElementCollection
    private Map<Locale, String> namesToDescription = new HashMap<>();

    public UserRole() {}

    public UserRole(Long id, String nameToSystem) {
        this.id = id;
        this.nameToSystem = nameToSystem;
    }

    public UserRole(Long id, String nameToSystem, Map<Locale, String> namesToView, Map<Locale, String> namesToDescription) {
        this.id = id;
        this.nameToSystem = nameToSystem;
        this.namesToView = namesToView;
        this.namesToDescription = namesToDescription;
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
    public Map<Locale, String> getNamesToDescription() {
        return namesToDescription;
    }
    public void setNamesToDescription(Map<Locale, String> namesToDescription) {
        this.namesToDescription = namesToDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(nameToSystem, userRole.nameToSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToSystem);
    }
}
