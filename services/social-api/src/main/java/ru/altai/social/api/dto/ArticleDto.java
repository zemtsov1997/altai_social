package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.social.api.model.IArticle;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ArticleDto implements IArticle {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private String caption;
    private String description;
    private String text;
    private CampaignDto campaign;

    public ArticleDto(IArticle article) {
        this.id = article.getId();
        this.caption = article.getCaption();
        this.description = article.getDescription();
        this.text = article.getText();
        this.campaign = new CampaignDto(article.getCampaign());
    }

}
