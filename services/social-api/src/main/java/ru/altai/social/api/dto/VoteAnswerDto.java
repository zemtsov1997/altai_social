package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.service.api.dto.name.NameSystemDto;
import ru.altai.service.api.dto.name.NameViewDto;
import ru.altai.social.api.model.IVoteAnswer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VoteAnswerDto implements IVoteAnswer {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private NameSystemDto nameSystem;
    private NameViewDto nameView;

    public VoteAnswerDto(IVoteAnswer voteAnswer) {
        this.id = voteAnswer.getId();
        this.nameSystem = new NameSystemDto(voteAnswer.getNameSystem());
        this.nameView = new NameViewDto(voteAnswer.getNameView());
    }

}
