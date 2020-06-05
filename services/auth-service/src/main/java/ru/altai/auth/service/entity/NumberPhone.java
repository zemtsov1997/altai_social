package ru.altai.auth.service.entity;

import ru.altai.service.api.model.INumberPhone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class NumberPhone implements INumberPhone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\+[0-9]{1,5}", message = "error.number.phone.code.pattern")
    @Size(min = 2, max = 6, message = "error.number.phone.code.size")
    private String code;

    @Pattern(regexp = "[0-9]{10}", message = "error.number.phone.number.pattern")
    @Size(min = 10, max = 10, message = "error.number.phone.number.size")
    private String number;

    public NumberPhone() {}

    public NumberPhone(String code, String number) {
        this.code = code;
        this.number = number;
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return code+number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberPhone that = (NumberPhone) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }
}
