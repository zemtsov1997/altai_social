package ru.altai.service.api.model.database;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;

public class PredicateLinkedList extends LinkedList<Predicate> implements PredicateList { }
