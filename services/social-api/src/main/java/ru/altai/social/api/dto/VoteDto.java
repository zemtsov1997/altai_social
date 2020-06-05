package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.social.api.model.IVote;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VoteDto implements IVote {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private VoteAnswerDto answer;
    private Long userId;
    private Long campaignId;

    public VoteDto(IVote vote) {
        this.id = vote.getId();
        this.answer = new VoteAnswerDto(vote.getAnswer());
        this.userId = vote.getUserId();
        this.campaignId = vote.getCampaignId();
    }

}
