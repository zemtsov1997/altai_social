package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.ArticleTypeControllerDao;
import ru.altai.social.service.entity.ArticleType;
import ru.altai.social.service.repository.ArticleTypeRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class ArticleTypeController implements ArticleTypeControllerDao<ArticleType> {

    private final ArticleTypeRepository articleTypeRepository;

    @Override
    public List<ArticleType> findAll(Map<String, Object> params) {
        return StreamSupport.stream(articleTypeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleType find(@Min(1) Long id) {
        return articleTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public ArticleType create(@Valid ArticleType obj) {
        return articleTypeRepository.save(obj);
    }

    @Override
    public ArticleType update(@Min(1) Long id, @Valid ArticleType newObj) {
        return articleTypeRepository.save(newObj);
    }

    @Override
    public void delete(@Min(1) Long id) {
        articleTypeRepository.deleteById(id);
    }

}
