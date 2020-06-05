package ru.altai.social.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.altai.social.api.model.IVoteAnswer;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public interface VoteAnswerControllerDao<T extends IVoteAnswer> {

    @GetMapping(value = "/voteAnswers", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> findAll(@RequestParam(required = false) Map<String, Object> params);

    @GetMapping(value = "/voteAnswers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T find(@PathVariable(name = "id") @Min(1) Long id);

    @PostMapping(value = "/voteAnswers", produces = MediaType.APPLICATION_JSON_VALUE)
    T create(@Valid @RequestBody T obj);

    @PutMapping(value = "/voteAnswers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T update(@PathVariable(name = "id") @Min(1) Long id, @Valid @RequestBody T newObj);

    @DeleteMapping(value = "/voteAnswers/{id}")
    void delete(@PathVariable(name = "id") @Min(1) Long id);

}
