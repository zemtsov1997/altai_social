package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.api.dao.ProfileControllerDao;
import ru.altai.auth.service.entity.Profile;
import ru.altai.auth.service.repository.ProfileRepository;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
public class ProfileController implements ProfileControllerDao<Profile> {

    @Autowired private ProfileRepository profileRepository;

    @Override
    public Profile find(@Min(1) Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Profile create(@Valid Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(@Min(1) Long id, @Valid Profile newProfile) {
        return profileRepository.findById(id)
            .map(profile -> {
                profile.setLastName(newProfile.getLastName());
                profile.setFirstName(newProfile.getFirstName());
                profile.setMiddleName(newProfile.getMiddleName());
                profile.setGenderId(newProfile.getGenderId());
                profile.setNumberPhone(newProfile.getNumberPhone());
                profile.setEmail(newProfile.getEmail());
                profile.setDateBirthday(newProfile.getDateBirthday());
                profile.setAvatarId(newProfile.getAvatarId());
                return profileRepository.save(profile);
            }).orElseGet(() -> {
                newProfile.setId(id);
                return profileRepository.save(newProfile);
            });
    }

    @Override
    public void delete(@Min(1) Long id) {
        profileRepository.deleteById(id);
    }
}
