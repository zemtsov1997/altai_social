package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.api.dao.AppUserControllerDao;
import ru.altai.auth.api.props.PersistenceAuthProps;
import ru.altai.auth.service.entity.AppUser;
import ru.altai.auth.service.repository.AppUserRepository;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Validated
public class AppUserController implements AppUserControllerDao<AppUser> {

    @Autowired private AppUserRepository appUserRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public List<AppUser> findAll(Map<String, Object> params) {
        if (params.containsKey(PersistenceAuthProps.USERNAME)) {
            String username = params.get(PersistenceAuthProps.USERNAME).toString();
            return appUserRepository.findAllByUsername(username);
        } else {
            return StreamSupport
                    .stream(appUserRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public AppUser find(@Min(1) Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public AppUser create(@Valid AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser update(@Min(1) Long id, @Valid AppUser newAppUser) {
        return appUserRepository.findById(id)
            .map(appUser -> {
                appUser.setUsername(newAppUser.getUsername());
                if (!appUser.getPassword().equals(newAppUser.getPassword())) {
                    appUser.setPassword(passwordEncoder.encode(newAppUser.getPassword()));
                } else {
                    appUser.setPassword(newAppUser.getPassword());
                }
                appUser.setEnabled(newAppUser.getEnabled());
                appUser.setRoles(newAppUser.getRoles());
                appUser.setProfile(newAppUser.getProfile());
                return appUserRepository.save(appUser);
            }).orElseGet(() -> {
                newAppUser.setId(id);
                return appUserRepository.save(newAppUser);
            });
    }

    @Override
    public void delete(@Min(1) Long id) {
        appUserRepository.deleteById(id);
    }
}
