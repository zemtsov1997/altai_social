package ru.altai.social.service.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.service.entity.Article;
import ru.altai.social.service.entity.Campaign;
import ru.altai.social.service.entity.CampaignStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@DisplayName("ArticleRepository test")
@SpringBootTest
@ActiveProfiles("test")
class ArticleRepositoryTest {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private CampaignStatusRepository campaignStatusRepository;

    @Test
    @DisplayName("find")
    void find() {
        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Article article = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article);

        Article article1 = articleRepository.findById(article.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(article1);
    }

    @Test
    @DisplayName("findAll")
    void findAll() {
        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Article article = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article);

        Article article1 = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article1);

        Article article2 = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article2);

        List<Article> list = StreamSupport.stream(articleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("create")
    void create() {
        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Article article = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article);

        Article article1 = articleRepository.findById(article.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(article1);
    }

    @Test
    @DisplayName("update")
    void update() {
        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);
        CampaignStatus campaignStatus2 = campaignStatusRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);

        Article article = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus1)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article);

        Article article1 = articleRepository.findById(article.getId())
                .orElseThrow(EntityNotFoundException::new);
        article1.getCampaign().setCampaignStatus(campaignStatus2);
        articleRepository.save(article1);

        Article article2 = articleRepository.findById(article1.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(article2.getCampaign().getCampaignStatus(), campaignStatus2);
    }

    @Test
    @DisplayName("delete")
    void delete() {
        CampaignStatus campaignStatus2 = campaignStatusRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);

        Article article = Article.builder()
                .campaign(Campaign.builder()
                        .campaignStatus(campaignStatus2)
                        .build())
                .caption("caption")
                .description("description")
                .text("text")
                .build();
        articleRepository.save(article);

        articleRepository.deleteById(article.getId());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            articleRepository.findById(article.getId())
                    .orElseThrow(EntityNotFoundException::new);
        });
    }

}