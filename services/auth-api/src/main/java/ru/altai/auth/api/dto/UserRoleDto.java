package ru.altai.auth.api.dto;

import ru.altai.auth.api.model.IUserRole;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class UserRoleDto implements IUserRole {

    private Long id;

    private String nameToSystem;

    private Map<Locale, String> namesToView = new HashMap<>();

    private Map<Locale, String> namesToDescription = new HashMap<>();

    public UserRoleDto() {}

    public UserRoleDto(String nameToSystem) {
        this.nameToSystem = nameToSystem;
    }

    public UserRoleDto(
            Long id,
            String nameToSystem,
            Map<Locale, String> namesToView,
            Map<Locale, String> namesToDescription
    ) {
        this.id = id;
        this.nameToSystem = nameToSystem;
        this.namesToView = namesToView;
        this.namesToDescription = namesToDescription;
    }

    public UserRoleDto(IUserRole userRole) {
        this.id = userRole.getId();
        this.nameToSystem = userRole.getNameToSystem();
        this.namesToView = userRole.getNamesToView();
        this.namesToDescription = userRole.getNamesToDescription();
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
        UserRoleDto userRole = (UserRoleDto) o;
        return Objects.equals(nameToSystem, userRole.nameToSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToSystem);
    }

}
