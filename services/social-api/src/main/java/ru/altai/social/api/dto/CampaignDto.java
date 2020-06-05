package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.social.api.model.ICampaign;

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
    private CampaignStatusDto campaignStatus;
    private Set<VoteDto> votes = new HashSet<>();

    public CampaignDto(ICampaign campaign) {
        this.id = campaign.getId();
        this.campaignStatus = new CampaignStatusDto(campaign.getCampaignStatus());
        votes.clear();
        campaign.getVotes().stream().forEach(vote -> votes.add(new VoteDto(vote)));
    }

}
