package ru.altai.social.service.entity;

import lombok.*;
import ru.altai.social.api.model.ICampaign;

import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.EAGER)
    private CampaignStatus campaignStatus;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaignId")
    private Set<Vote> votes;

}
