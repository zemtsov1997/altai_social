package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.api.dao.GenderControllerDao;
import ru.altai.auth.service.entity.Gender;
import ru.altai.auth.service.repository.GenderRepository;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Validated
public class GenderController implements GenderControllerDao<Gender> {

    @Autowired private GenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return StreamSupport
                .stream(genderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Gender find(@Min(1) Long id) {
        return genderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
}
