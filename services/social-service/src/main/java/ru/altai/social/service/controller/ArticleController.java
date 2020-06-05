package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.ArticleControllerDao;
import ru.altai.social.service.entity.Article;
import ru.altai.social.service.entity.Campaign;
import ru.altai.social.service.repository.ArticleRepository;
import ru.altai.social.service.repository.CampaignRepository;
import ru.altai.social.service.repository.VoteRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.Specification.where;
import static ru.altai.social.service.repository.ArticleSpecifications.likeCaption;
import static ru.altai.social.service.repository.ArticleSpecifications.withCampaignStatusId;

@RestController
@AllArgsConstructor
public class ArticleController implements ArticleControllerDao<Article> {

    private final ArticleRepository articleRepository;
    private final CampaignRepository campaignRepository;
    private final VoteRepository voteRepository;

    @Override
    public List<Article> findAll(Map<String, Object> params) {
        List<Article> list = articleRepository.findAll(where(likeCaption(params.get("caption")))
                                                        .and(withCampaignStatusId(params.get("campaignStatusId"))));
        return list;
    }

    @Override
    public Article find(@Min(1) Long id) {
        return articleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Article create(@Valid Article obj) {
        return articleRepository.save(obj);
    }

    @Override
    public Article update(@Min(1) Long id, @Valid Article newObj) {
        return articleRepository.save(newObj);
    }

    @Transactional
    @Override
    public void delete(@Min(1) Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        Campaign campaign = article.getCampaign();
        if (campaign != null) {
            voteRepository.deleteByCampaignId(campaign.getId());
            campaignRepository.deleteById(campaign.getId());
        }
        articleRepository.deleteById(id);
    }

}
