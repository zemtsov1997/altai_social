package ru.altai.auth.service.service;

import org.springframework.stereotype.Service;
import ru.altai.auth.api.props.UserRoleRequestParam;
import ru.altai.auth.service.entity.UserRole;
import ru.altai.service.api.PersistenceSeparator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserRole> findAll(Map<String, Object> params) {
        @SuppressWarnings("unchecked")
        List<UserRole> list = createQuery("SELECT userRole FROM UserRole as userRole", params).getResultList();
        return list;
    }

    public List<UserRole> findAllByProfileId(Long id) {
        String sql = "SELECT appUser.roles FROM AppUser as appUser" +
                " JOIN Profile as profile ON appUser.profile.id = profile.id" +
                " WHERE appUser.profile.id = :profileId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("profileId", id);
        @SuppressWarnings("unchecked")
        List<UserRole> list = query.getResultList();
        return list;
    }

    private Query createQuery(String sql, Map<String, Object> params) {
        PersistenceSeparator separator = new PersistenceSeparator();

        Object linkSystemToName = params.get(UserRoleRequestParam.NAME_TO_SYSTEM);

        String systemToName = validParam(linkSystemToName) ? linkSystemToName.toString() : null;

        if (systemToName != null) sql += separator.get() + " appUser.systemToName = :systemToName";

        Query query = entityManager.createQuery(sql);
        if (systemToName != null) query.setParameter("systemToName", systemToName);

        return query;
    }

    private Boolean validParam(Object param) {
        return param != null && !param.toString().isEmpty();
    }

}
