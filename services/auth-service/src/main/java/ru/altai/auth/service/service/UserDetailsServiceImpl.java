package ru.altai.auth.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.altai.auth.service.entity.AppUser;
import ru.altai.auth.service.repository.AppUserRepository;
import ru.altai.auth.api.model.IUserRole;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
        List<GrantedAuthority> grantedAuthorities = appUser.getRoles().stream()
                .map(IUserRole::getNameToSystem)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);

    }

}