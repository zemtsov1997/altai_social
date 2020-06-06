package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.IArticleType;
import ru.altai.social.service.entity.name.NameSystem;
import ru.altai.social.service.entity.name.NameView;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class ArticleType implements IArticleType {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private NameSystem nameSystem;
    @Embedded
    private NameView nameView;

    public ArticleType(IArticleType iArticleType) {
        this.id = iArticleType.getId();
        this.nameSystem = new NameSystem(iArticleType.getNameSystem());
        this.nameView = new NameView(iArticleType.getNameView());
    }

}
