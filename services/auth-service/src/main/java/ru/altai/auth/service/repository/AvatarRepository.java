package ru.altai.auth.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.altai.auth.service.entity.Avatar;

public interface AvatarRepository extends CrudRepository<Avatar, Long> { }