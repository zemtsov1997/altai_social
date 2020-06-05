package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.CampaignStatusControllerDao;
import ru.altai.social.service.entity.CampaignStatus;
import ru.altai.social.service.repository.CampaignStatusRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class CampaignStatusController implements CampaignStatusControllerDao<CampaignStatus> {

    private final CampaignStatusRepository campaignStatusRepository;

    @Override
    public List<CampaignStatus> findAll(Map<String, Object> params) {
        return StreamSupport.stream(campaignStatusRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public CampaignStatus find(@Min(1) Long id) {
        return campaignStatusRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public CampaignStatus create(@Valid CampaignStatus obj) {
        return campaignStatusRepository.save(obj);
    }

    @Override
    public CampaignStatus update(@Min(1) Long id, @Valid CampaignStatus newObj) {
        return campaignStatusRepository.save(newObj);
    }

    @Override
    public void delete(@Min(1) Long id) {
        campaignStatusRepository.deleteById(id);
    }

}
