package ru.altai.social.service.entity.name;

import ru.altai.service.api.model.name.INameSystem;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NameSystem implements INameSystem, Serializable {

    private String nameSystem;

    public NameSystem() { }

    public NameSystem(INameSystem nameSystem) {
        this.nameSystem = nameSystem.getName();
    }

    @Override
    public String getName() {
        return nameSystem;
    }
    public void setName(String name) {
        this.nameSystem = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameSystem that = (NameSystem) o;
        return Objects.equals(nameSystem, that.nameSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSystem);
    }

    @Override
    public String toString() {
        return nameSystem;
    }
}
