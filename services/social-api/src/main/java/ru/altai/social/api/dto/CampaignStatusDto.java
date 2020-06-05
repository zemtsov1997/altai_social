package ru.altai.social.api.dto;

import lombok.*;
import ru.altai.service.api.dto.name.NameSystemDto;
import ru.altai.service.api.dto.name.NameViewDto;
import ru.altai.social.api.model.ICampaignStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CampaignStatusDto implements ICampaignStatus {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private NameSystemDto nameSystem;
    private NameViewDto nameView;

    public CampaignStatusDto(ICampaignStatus campaignStatus) {
        this.id = campaignStatus.getId();
        this.nameSystem = new NameSystemDto(campaignStatus.getNameSystem());
        this.nameView = new NameViewDto(campaignStatus.getNameView());
    }

}
