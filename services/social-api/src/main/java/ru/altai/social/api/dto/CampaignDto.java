package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.social.api.model.ICampaign;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CampaignDto implements ICampaign {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private LocalDateTime dateCreate;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    private CampaignStatusDto campaignStatus;
    private Set<VoteDto> votes = new HashSet<>();

    public CampaignDto(ICampaign campaign) {
        this.id = campaign.getId();
        this.dateCreate = campaign.getDateCreate();
        this.dateStart = campaign.getDateStart();
        this.dateFinish = campaign.getDateFinish();
        this.campaignStatus = new CampaignStatusDto(campaign.getCampaignStatus());
        votes.clear();
        campaign.getVotes().stream().forEach(vote -> votes.add(new VoteDto(vote)));
    }

}
