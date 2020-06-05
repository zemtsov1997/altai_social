package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.VoteAnswerControllerDao;
import ru.altai.social.service.entity.VoteAnswer;
import ru.altai.social.service.repository.VoteAnswerRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class VoteAnswerController implements VoteAnswerControllerDao<VoteAnswer> {

    private final VoteAnswerRepository voteAnswerRepository;

    @Override
    public List<VoteAnswer> findAll(Map<String, Object> params) {
        return StreamSupport.stream(voteAnswerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public VoteAnswer find(@Min(1) Long id) {
        return voteAnswerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public VoteAnswer create(@Valid VoteAnswer obj) {
        return voteAnswerRepository.save(obj);
    }

    @Override
    public VoteAnswer update(@Min(1) Long id, @Valid VoteAnswer newObj) {
        return voteAnswerRepository.save(newObj);
    }

    @Override
    public void delete(@Min(1) Long id) {
        voteAnswerRepository.deleteById(id);
    }

}
