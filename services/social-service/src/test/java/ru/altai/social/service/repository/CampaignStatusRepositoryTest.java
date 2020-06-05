package ru.altai.social.service.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.service.entity.CampaignStatus;
import ru.altai.social.service.entity.name.NameSystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DisplayName("CampaignStatusRepository test")
@SpringBootTest
@ActiveProfiles("test")
class CampaignStatusRepositoryTest {

    @Autowired private CampaignStatusRepository campaignStatusRepository;

    @Test
    @DisplayName("find")
    void find() {
        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);
        CampaignStatus campaignStatus2 = campaignStatusRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);
        CampaignStatus campaignStatus3 = campaignStatusRepository.findById(3L)
                .orElseThrow(EntityNotFoundException::new);
        CampaignStatus campaignStatus4 = campaignStatusRepository.findById(4L)
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(campaignStatus1);
        Assertions.assertNotNull(campaignStatus2);
        Assertions.assertNotNull(campaignStatus3);
        Assertions.assertNotNull(campaignStatus4);
    }

    @Test
    @DisplayName("findAll")
    void findAll() {
        List<CampaignStatus> list = StreamSupport.stream(campaignStatusRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("create")
    void create() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        CampaignStatus campaignStatus = CampaignStatus.builder()
                .nameSystem(nameSystem)
                .build();
        campaignStatusRepository.save(campaignStatus);

        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(campaignStatus.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(campaignStatus1);
    }

    @Test
    @DisplayName("update")
    void update() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        NameSystem nameSystem2 = new NameSystem();
        nameSystem2.setName("TEST2");

        CampaignStatus campaignStatus = CampaignStatus.builder()
                .nameSystem(nameSystem)
                .build();
        campaignStatusRepository.save(campaignStatus);

        CampaignStatus campaignStatus1 = campaignStatusRepository.findById(campaignStatus.getId())
                .orElseThrow(EntityNotFoundException::new);
        campaignStatus1.setNameSystem(nameSystem2);
        campaignStatusRepository.save(campaignStatus1);

        CampaignStatus campaignStatus2 = campaignStatusRepository.findById(campaignStatus1.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(campaignStatus2.getNameSystem(), nameSystem2);
    }

    @Test
    @DisplayName("delete")
    void delete() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        CampaignStatus campaignStatus = CampaignStatus.builder()
                .nameSystem(nameSystem)
                .build();
        campaignStatusRepository.save(campaignStatus);

        campaignStatusRepository.deleteById(campaignStatus.getId());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            campaignStatusRepository.findById(campaignStatus.getId())
                    .orElseThrow(EntityNotFoundException::new);
        });
    }

}