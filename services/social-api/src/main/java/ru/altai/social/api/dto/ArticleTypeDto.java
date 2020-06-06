package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.service.api.dto.name.NameSystemDto;
import ru.altai.service.api.dto.name.NameViewDto;
import ru.altai.social.api.model.IArticleType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ArticleTypeDto implements IArticleType {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private NameSystemDto nameSystem;
    private NameViewDto nameView;

    public ArticleTypeDto(IArticleType iArticleType) {
        this.id = iArticleType.getId();
        this.nameSystem = new NameSystemDto(iArticleType.getNameSystem());
        this.nameView = new NameViewDto(iArticleType.getNameView());
    }

}
