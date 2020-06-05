package ru.altai.social.service.repository;

import com.google.common.base.Strings;
import org.springframework.data.jpa.domain.Specification;
import ru.altai.social.service.entity.Article;

public class ArticleSpecifications {

    public static Specification<Article> likeCaption(Object caption) {
        if (caption == null || Strings.isNullOrEmpty(caption.toString())) {
            return null;
        } else {
            return (root, query, cb) -> cb.like(root.get("caption"), caption.toString());
        }
    }

    public static Specification<Article> withCampaignStatusId(Object id) {
        if (id == null || Strings.isNullOrEmpty(id.toString())) {
            return null;
        } else {
            return (root, query, cb) -> cb.equal(root.get("campaign").get("campaignStatus").get("id"), Long.valueOf(id.toString()));
        }
    }

}
