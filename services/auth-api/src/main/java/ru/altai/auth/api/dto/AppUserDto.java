package ru.altai.auth.api.dto;

import ru.altai.auth.api.model.IAppUser;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AppUserDto implements IAppUser {

    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Set<UserRoleDto> roles = new HashSet<>();
    private ProfileDto profile;

    public AppUserDto() { }

    public AppUserDto(Long id, String username, String password, Boolean enabled, Set<UserRoleDto> roles, ProfileDto profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.profile = profile;
    }

    public AppUserDto(IAppUser appUser) {
        this.id = appUser.getId();
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.enabled = appUser.getEnabled();
        this.roles = StreamSupport
                .stream(appUser.getRoles().spliterator(), false)
                .map(UserRoleDto::new).collect(Collectors.toSet());
        this.profile = (ProfileDto) appUser.getProfile();
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public Set<UserRoleDto> getRoles() {
        return roles;
    }
    public void setRoles(Set<UserRoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public ProfileDto getProfile() {
        return profile;
    }
    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, enabled, roles, profile);
    }
}
