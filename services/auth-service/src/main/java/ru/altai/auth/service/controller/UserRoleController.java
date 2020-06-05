package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.api.dao.UserRoleControllerDao;
import ru.altai.auth.api.props.UserRoleRequestParam;
import ru.altai.auth.service.entity.UserRole;
import ru.altai.auth.service.repository.UserRoleRepository;
import ru.altai.auth.service.service.UserRoleService;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class UserRoleController implements UserRoleControllerDao<UserRole> {

    @Autowired private UserRoleRepository userRoleRepository;
    @Autowired private UserRoleService userRoleService;

    @Override
    public List<UserRole> findAll(Map<String, Object> params) {

        if (params.get(UserRoleRequestParam.PROFILE_ID) != null) {
            Long profileId = Long.valueOf(params.get(UserRoleRequestParam.PROFILE_ID).toString());
            return userRoleService.findAllByProfileId(profileId);
        }

        return userRoleService.findAll(params);
    }



    @Override
    public UserRole find(@Min(1) Long id) {
        return userRoleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

}
