package ru.altai.auth.api.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.altai.auth.api.model.IProfile;
import ru.altai.service.api.dto.NumberPhoneDto;

import java.time.LocalDate;
import java.util.Objects;

public class ProfileDto implements IProfile {

    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;

    private Long genderId;

    private NumberPhoneDto numberPhone;

    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBirthday;

    private Long avatarId;

    public ProfileDto() { }

    public ProfileDto(Long id, String lastName, String firstName, String middleName, Long genderId, NumberPhoneDto numberPhone, String email, LocalDate dateBirthday, Long avatarId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.genderId = genderId;
        this.numberPhone = numberPhone;
        this.email = email;
        this.dateBirthday = dateBirthday;
        this.avatarId = avatarId;
    }

    public ProfileDto(IProfile profile) {
        this.id = profile.getId();
        this.lastName = profile.getLastName();
        this.firstName = profile.getFirstName();
        this.middleName = profile.getMiddleName();
        this.genderId = profile.getGenderId();
        this.numberPhone = (NumberPhoneDto) profile.getNumberPhone();
        this.email = profile.getEmail();
        this.dateBirthday = profile.getDateBirthday();
        this.avatarId = profile.getAvatarId();
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public Long getGenderId() {
        return genderId;
    }
    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    @Override
    public NumberPhoneDto getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(NumberPhoneDto numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public LocalDate getDateBirthday() {
        return dateBirthday;
    }
    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    @Override
    public Long getAvatarId() {
        return avatarId;
    }
    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDto profile = (ProfileDto) o;
        return Objects.equals(lastName, profile.lastName) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(middleName, profile.middleName) &&
                Objects.equals(genderId, profile.genderId) &&
                Objects.equals(numberPhone, profile.numberPhone) &&
                Objects.equals(email, profile.email) &&
                Objects.equals(dateBirthday, profile.dateBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, genderId, numberPhone, email, dateBirthday);
    }

}
