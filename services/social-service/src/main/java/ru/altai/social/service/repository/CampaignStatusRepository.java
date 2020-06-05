package ru.altai.social.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.altai.social.service.entity.CampaignStatus;

@Repository
public interface CampaignStatusRepository extends CrudRepository<CampaignStatus, Long> {
}
