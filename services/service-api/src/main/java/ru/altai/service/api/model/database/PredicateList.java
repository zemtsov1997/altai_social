package ru.altai.service.api.model.database;

import javax.persistence.criteria.Predicate;
import java.util.List;

public interface PredicateList extends List<Predicate> {

    default public Predicate[] toGenericArray() {
        return this.toArray(new Predicate[this.size()]);
    }
}
