package ru.altai.social.service.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.service.entity.VoteAnswer;
import ru.altai.social.service.entity.name.NameSystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DisplayName("VoteAnswerRepository test")
@SpringBootTest
@ActiveProfiles("test")
class VoteAnswerRepositoryTest {

    @Autowired private VoteAnswerRepository voteAnswerRepository;

    @Test
    @DisplayName("find")
    void find() {
        VoteAnswer voteAnswer1 = voteAnswerRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);
        VoteAnswer voteAnswer2 = voteAnswerRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);
        VoteAnswer voteAnswer3 = voteAnswerRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);
        Assertions.assertNotNull(voteAnswer1);
        Assertions.assertNotNull(voteAnswer2);
        Assertions.assertNotNull(voteAnswer3);
    }

    @Test
    @DisplayName("findAll")
    void findAll() {
        List<VoteAnswer> list = StreamSupport.stream(voteAnswerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("create")
    void create() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        VoteAnswer voteAnswer1 = VoteAnswer.builder()
                .nameSystem(nameSystem)
                .build();
        voteAnswerRepository.save(voteAnswer1);

        VoteAnswer voteAnswer2 = voteAnswerRepository.findById(voteAnswer1.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertNotNull(voteAnswer2);
    }

    @Test
    @DisplayName("update")
    void update() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        VoteAnswer voteAnswer1 = VoteAnswer.builder()
                .nameSystem(nameSystem)
                .build();
        voteAnswerRepository.save(voteAnswer1);

        NameSystem nameSystem2 = new NameSystem();
        nameSystem2.setName("TEST2");

        VoteAnswer voteAnswer2 = voteAnswerRepository.findById(voteAnswer1.getId())
                .orElseThrow(EntityNotFoundException::new);
        voteAnswer2.setNameSystem(nameSystem2);
        voteAnswerRepository.save(voteAnswer2);

        VoteAnswer voteAnswer3 = voteAnswerRepository.findById(voteAnswer2.getId())
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(nameSystem2.getName(), voteAnswer3.getNameSystem().getName());
    }

    @Test
    @DisplayName("delete")
    void delete() {
        NameSystem nameSystem = new NameSystem();
        nameSystem.setName("TEST");

        VoteAnswer voteAnswer1 = VoteAnswer.builder()
                .nameSystem(nameSystem)
                .build();
        voteAnswerRepository.save(voteAnswer1);

        voteAnswerRepository.deleteById(voteAnswer1.getId());
    }

}