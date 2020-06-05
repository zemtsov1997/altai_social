package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.NumberPhone;

public interface NumberPhoneRepository extends CrudRepository<NumberPhone, Long> { }