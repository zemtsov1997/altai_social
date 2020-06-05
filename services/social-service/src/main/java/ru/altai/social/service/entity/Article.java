package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.IArticle;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Article implements IArticle {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caption;
    private String description;
    private String text;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Campaign campaign;

}
