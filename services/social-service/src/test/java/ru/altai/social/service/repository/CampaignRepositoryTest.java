package ru.altai.social.service.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.service.entity.Campaign;
import ru.altai.social.service.entity.CampaignStatus;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DisplayName("CampaignRepository test")
@SpringBootTest
@ActiveProfiles("test")
class CampaignRepositoryTest {

    @Autowired private CampaignRepository campaignRepository;
    @Autowired private CampaignStatusRepository campaignStatusRepository;

    @Test
    @DisplayName("find")
    void find() {
        CampaignStatus campaignStatus = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Campaign campaign1 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();
        campaignRepository.save(campaign1);

        Campaign campaign2 = campaignRepository.findById(campaign1.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(campaign2);
    }

    @Test
    @DisplayName("findAll")
    void  findAll() {
        CampaignStatus campaignStatus = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Campaign campaign1 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();
        campaignRepository.save(campaign1);

        Campaign campaign2 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();
        campaignRepository.save(campaign2);

        Campaign campaign3 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();
        campaignRepository.save(campaign3);

        List<Campaign> list = StreamSupport.stream(campaignRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("create")
    void create() {
        CampaignStatus campaignStatus = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Campaign campaign1 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();

        Assertions.assertNotNull(campaignRepository.save(campaign1));
    }

    @Test
    @DisplayName("update")
    void update() {
        CampaignStatus campaignStatus = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Campaign campaign1 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .votes(new HashSet<>())
                .build();
        campaignRepository.save(campaign1);

        Campaign campaign2 = campaignRepository.findById(campaign1.getId())
                .orElseThrow(EntityNotFoundException::new);
        campaignRepository.save(campaign2);

        Assertions.assertEquals(campaign1, campaign2);
    }

    @Test
    @DisplayName("delete")
    void delete() {
        CampaignStatus campaignStatus = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Campaign campaign1 = Campaign.builder()
                .campaignStatus(campaignStatus)
                .build();
        campaignRepository.save(campaign1);

        Campaign campaign2 = campaignRepository.findById(campaign1.getId())
                .orElseThrow(EntityNotFoundException::new);

        campaignRepository.deleteById(campaign2.getId());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            campaignRepository.findById(campaign2.getId())
                    .orElseThrow(EntityNotFoundException::new);
        });
    }

}