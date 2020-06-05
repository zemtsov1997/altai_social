package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.IVoteAnswer;
import ru.altai.social.service.entity.name.NameSystem;
import ru.altai.social.service.entity.name.NameView;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class VoteAnswer implements IVoteAnswer {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private NameSystem nameSystem;
    @Embedded
    private NameView nameView;

    public VoteAnswer(IVoteAnswer voteAnswer) {
        this.id = voteAnswer.getId();
        this.nameSystem = new NameSystem(voteAnswer.getNameSystem());
        this.nameView = new NameView(voteAnswer.getNameView());
    }

}
