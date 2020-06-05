package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> { }