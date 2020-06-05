package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    List<AppUser> findAllByUsername(String username);

    Long countByUsername(String username);

}