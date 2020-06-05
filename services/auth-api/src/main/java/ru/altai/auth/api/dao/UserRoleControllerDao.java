package ru.altai.auth.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.altai.auth.api.model.IUserRole;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public interface UserRoleControllerDao<T extends IUserRole> {

    @GetMapping(value = "/userRoles", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll(@RequestParam(required = false) Map<String, Object> params);

    @GetMapping(value = "/userRoles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

}
