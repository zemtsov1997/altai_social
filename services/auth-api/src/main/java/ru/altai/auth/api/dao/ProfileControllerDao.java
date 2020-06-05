package ru.altai.auth.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.altai.auth.api.model.IProfile;

import javax.validation.Valid;
import javax.validation.constraints.Min;

public interface ProfileControllerDao<T extends IProfile> {

    @GetMapping(value = "/profiles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

    @PostMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
    T create(@Valid @RequestBody T profile);

    @PutMapping(value = "/profiles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T update(@PathVariable(name = "id") @Min(1) Long id, @Valid @RequestBody T newProfile);

    @DeleteMapping(value = "/profiles/{id}")
    void delete(@PathVariable(name = "id") @Min(1) Long id);

}
