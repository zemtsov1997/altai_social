package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    Iterable<UserRole> findAllByNameToSystem(String nameSystem);

}