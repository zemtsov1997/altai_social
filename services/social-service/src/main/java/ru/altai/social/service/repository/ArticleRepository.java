package ru.altai.social.service.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.altai.social.service.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>, JpaSpecificationExecutor<Article> {
}
