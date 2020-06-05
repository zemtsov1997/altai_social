package ru.altai.social.service.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.service.entity.Campaign;
import ru.altai.social.service.entity.Vote;
import ru.altai.social.service.entity.VoteAnswer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DisplayName("VoteRepository test")
@SpringBootTest
@ActiveProfiles("test")
class VoteRepositoryTest {

    @Autowired private VoteRepository voteRepository;
    @Autowired private VoteAnswerRepository voteAnswerRepository;
    @Autowired private CampaignRepository campaignRepository;

    @Test
    @DisplayName("find")
    void find() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        Vote vote2 = voteRepository.findById(vote.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(vote2);
    }

    @Test
    @DisplayName("findAll")
    void findAll() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote1 = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote1);

        Vote vote2 = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote2);

        Vote vote3 = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote3);

        List<Vote> list = StreamSupport.stream(voteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("findAllByCampaignId")
    void findAllByCampaignId() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        List<Vote> list = voteRepository.findAllByCampaignId(campaign1.getId());
        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @Transactional
    @DisplayName("deleteByCampaignId")
    void deleteByCampaignId() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        voteRepository.deleteByCampaignId(campaign1.getId());

        List<Vote> list = voteRepository.findAllByCampaignId(campaign1.getId());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("create")
    void create() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        Vote vote2 = voteRepository.findById(vote.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(vote2);
    }

    @Test
    @DisplayName("update")
    void update() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        Vote vote2 = voteRepository.findById(vote.getId())
                .orElseThrow(EntityNotFoundException::new);
        vote2.setUserId(2L);
        voteRepository.save(vote2);

        Vote vote3 = voteRepository.findById(vote.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(vote2, vote3);
    }

    @Test
    @DisplayName("delete")
    void delete() {
        Campaign campaign1 = Campaign.builder()
                .build();
        campaignRepository.save(campaign1);

        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Vote vote = Vote.builder()
                .userId(1L)
                .answer(voteAnswer1)
                .campaignId(campaign1.getId())
                .build();
        voteRepository.save(vote);

        Vote vote2 = voteRepository.findById(vote.getId())
                .orElseThrow(EntityNotFoundException::new);
        voteRepository.delete(vote2);

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            voteRepository.findById(vote2.getId())
                    .orElseThrow(EntityNotFoundException::new);
        });
    }
}