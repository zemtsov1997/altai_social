package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.service.entity.NumberPhone;
import ru.altai.auth.service.repository.NumberPhoneRepository;
import ru.altai.service.api.dao.NumberPhoneControllerDao;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Validated
public class NumberPhoneController implements NumberPhoneControllerDao<NumberPhone> {

    @Autowired private NumberPhoneRepository numberPhoneRepository;

    @Override
    public List<NumberPhone> findAll() {
        return StreamSupport
                .stream(numberPhoneRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public NumberPhone find(@Min(1) Long id) {
        return numberPhoneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public NumberPhone create(@Valid NumberPhone object) {
        return numberPhoneRepository.save(object);
    }

    @Override
    public NumberPhone update(@Min(1) Long id, @Valid NumberPhone newObject) {
        return numberPhoneRepository.findById(id).map( numberPhone -> {
            numberPhone.setCode(newObject.getCode());
            numberPhone.setNumber(newObject.getNumber());
            return numberPhoneRepository.save(numberPhone);
        }).orElseGet(() -> {
            newObject.setId(id);
            return numberPhoneRepository.save(newObject);
        });
    }

    @Override
    public void delete(@Min(1) Long id) {
        numberPhoneRepository.deleteById(id);
    }
}
