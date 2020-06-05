package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.IVote;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Vote implements IVote {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private VoteAnswer answer;
    private Long userId;
    private Long campaignId;

}
