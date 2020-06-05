package ru.altai.auth.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.altai.auth.service.repository.AppUserRepository;

@Service
public class AppUserService {

    @Autowired private AppUserRepository appUserRepository;

    public Boolean isHaveLogin(String username) {
        return appUserRepository.countByUsername(username) > 0;
    }

}
