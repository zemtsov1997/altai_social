package ru.altai.social.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.altai.social.api.model.ICampaign;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public interface CampaignControllerDao<T extends ICampaign> {

    @GetMapping(value = "/campaigns", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll(@RequestParam(required = false) Map<String, Object> params);

    @GetMapping(value = "/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

    @PostMapping(value = "/campaigns", produces = MediaType.APPLICATION_JSON_VALUE)
    T create(@Valid @RequestBody T obj);

    @PutMapping(value = "/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T update(@PathVariable(name = "id") @Min(1) Long id, @Valid @RequestBody T newObj);

    @DeleteMapping(value = "/campaigns/{id}")
    void delete(@PathVariable(name = "id") @Min(1) Long id);

}
