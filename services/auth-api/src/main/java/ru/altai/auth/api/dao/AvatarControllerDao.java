package ru.altai.auth.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.altai.auth.api.model.IAvatar;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public interface AvatarControllerDao<T extends IAvatar> {

    @GetMapping(value = "/avatars/{id}/image", produces = MediaType.APPLICATION_JSON_VALUE)
    byte[] findImage(@PathVariable(name = "id") @Min(1) Long id, @RequestParam(required = false) Map<String, Object> params);

    @GetMapping(value = "/avatars", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll();

    @GetMapping(value = "/avatars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

    @PostMapping(value = "/avatars", produces = MediaType.APPLICATION_JSON_VALUE)
    T create(@RequestBody T object);

    @PutMapping(value = "/avatars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T update(@PathVariable(name = "id") @Min(1) Long id, @RequestBody T newObject);

    @DeleteMapping(value = "/avatars/{id}")
    void delete(@PathVariable(name = "id") @Min(1) Long id);

}
