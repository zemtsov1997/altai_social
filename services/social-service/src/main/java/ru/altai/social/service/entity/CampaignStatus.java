package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.ICampaignStatus;
import ru.altai.social.service.entity.name.NameSystem;
import ru.altai.social.service.entity.name.NameView;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class CampaignStatus implements ICampaignStatus {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private NameSystem nameSystem;
    @Embedded
    private NameView nameView;

    public CampaignStatus(ICampaignStatus campaignStatus) {
        this.id = campaignStatus.getId();
        this.nameSystem = new NameSystem(campaignStatus.getNameSystem());
        this.nameView = new NameView(campaignStatus.getNameView());
    }

}
