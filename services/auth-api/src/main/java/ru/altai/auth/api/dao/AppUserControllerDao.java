package ru.altai.auth.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.altai.auth.api.model.IAppUser;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public interface AppUserControllerDao<T extends IAppUser> {

    @GetMapping(value = "/appUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll(@RequestParam(required = false) Map<String, Object> params);

    @GetMapping(value = "/appUsers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

    @PostMapping(value = "/appUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    T create(@Valid @RequestBody T appUser);

    @PutMapping(value = "/appUsers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T update(@PathVariable(name = "id") @Min(1) Long id, @Valid @RequestBody T newAppUser);

    @DeleteMapping(value = "/appUsers/{id}")
    void delete(@PathVariable(name = "id") @Min(1) Long id);

}
