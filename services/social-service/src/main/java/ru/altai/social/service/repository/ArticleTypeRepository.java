package ru.altai.social.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.altai.social.service.entity.ArticleType;

@Repository
public interface ArticleTypeRepository extends CrudRepository<ArticleType, Long> {
}
