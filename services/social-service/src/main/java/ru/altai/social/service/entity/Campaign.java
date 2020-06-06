package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.ICampaign;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Campaign implements ICampaign {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreate;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    @ManyToOne(fetch = FetchType.EAGER)
    private CampaignStatus campaignStatus;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaignId")
    private Set<Vote> votes;

    public Campaign(ICampaign iCampaign) {
        this.id = iCampaign.getId();
        this.dateCreate = iCampaign.getDateCreate();
        this.dateStart = iCampaign.getDateStart();
        this.dateFinish = iCampaign.getDateFinish();
        this.setCampaignStatus(new CampaignStatus(iCampaign.getCampaignStatus()));
        votes.clear();
        iCampaign.getVotes().stream().forEach(vote -> votes.add(new Vote(vote)));
    }

}
