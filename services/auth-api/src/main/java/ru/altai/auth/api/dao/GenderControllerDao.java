package ru.altai.auth.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.altai.auth.api.model.IGender;

import javax.validation.constraints.Min;
import java.util.List;

public interface GenderControllerDao<T extends IGender> {

    @GetMapping(value = "/genders", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll();

    @GetMapping(value = "/genders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

}
