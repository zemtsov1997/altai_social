package ru.altai.social.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.service.api.exeption.EntityNotFoundException;
import ru.altai.social.api.dao.CampaignControllerDao;
import ru.altai.social.service.entity.Campaign;
import ru.altai.social.service.repository.CampaignRepository;
import ru.altai.social.service.repository.VoteRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class CampaignController implements CampaignControllerDao<Campaign> {

    private final CampaignRepository campaignRepository;
    private final VoteRepository voteRepository;

    @Override
    public List<Campaign> findAll(Map<String, Object> params) {
        return StreamSupport.stream(campaignRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Campaign find(@Min(1) Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Campaign create(@Valid Campaign obj) {
        return campaignRepository.save(obj);
    }

    @Override
    public Campaign update(@Min(1) Long id, @Valid Campaign newObj) {
        return campaignRepository.save(newObj);
    }

    @Transactional
    @Override
    public void delete(@Min(1) Long id) {
        voteRepository.deleteByCampaignId(id);
        campaignRepository.deleteById(id);
    }

}
