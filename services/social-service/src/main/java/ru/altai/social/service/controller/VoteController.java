package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.VoteControllerDao;
import ru.altai.social.service.entity.Vote;
import ru.altai.social.service.repository.VoteRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class VoteController implements VoteControllerDao<Vote> {

    private final VoteRepository voteRepository;

    @Override
    public List<Vote> findAll(Map<String, Object> params) {
        return StreamSupport.stream(voteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Vote find(@Min(1) Long id) {
        return voteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Vote create(@Valid Vote obj) {
        return voteRepository.save(obj);
    }

    @Override
    public Vote update(@Min(1) Long id, @Valid Vote newObj) {
        return voteRepository.save(newObj);
    }

    @Override
    public void delete(@Min(1) Long id) {
        voteRepository.deleteById(id);
    }

}
