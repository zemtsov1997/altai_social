package ru.altai.service.api.dto.name;

import ru.altai.service.api.model.name.INameSystem;

import java.util.Objects;

public class NameSystemDto implements INameSystem {

    private String name;

    public NameSystemDto() { }

    public NameSystemDto(INameSystem nameSystem) {
        this.name = nameSystem.getName();
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameSystemDto that = (NameSystemDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
