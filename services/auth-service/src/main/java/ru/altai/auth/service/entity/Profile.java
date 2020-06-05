package ru.altai.auth.service.entity;

import org.springframework.format.annotation.DateTimeFormat;
import ru.altai.auth.api.model.IProfile;
import ru.altai.service.api.annotation.ActualDateBirth;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Profile implements IProfile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 30, message = "error.user.last.name.size")
    private String lastName;
    @Size(min = 1, max = 30, message = "error.user.first.name.size")
    private String firstName;
    @Size(min = 1, max = 30, message = "error.user.middle.name.size")
    private String middleName;

    @NotNull(message = "error.gender.not.null")
    private Long genderId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Valid
    private NumberPhone numberPhone;

    @Email(message = "error.email.pattern")
    @Size(min = 1, max = 100, message = "error.email.size")
    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ActualDateBirth
    private LocalDate dateBirthday;

    private Long avatarId;

    public Profile() { }

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
    public NumberPhone getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(NumberPhone numberPhone) {
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
        Profile profile = (Profile) o;
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
