package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.Gender;

public interface GenderRepository extends CrudRepository<Gender, Long> {

    Iterable<Gender> findAllByNameToSystem(String nameSystem);

}