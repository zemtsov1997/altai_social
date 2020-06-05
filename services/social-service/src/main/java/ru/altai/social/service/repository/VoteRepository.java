package ru.altai.social.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.altai.social.service.entity.Vote;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    List<Vote> findAllByCampaignId(Long campaignId);

    void deleteByCampaignId(Long campaignId);

}
