package ru.altai.service.api.model.database;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PredicateArrayList extends ArrayList<Predicate> implements PredicateList { }
