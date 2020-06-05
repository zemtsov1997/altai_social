package ru.altai.auth.service.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.altai.auth.service.service.AppUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueUsername implements ConstraintValidator<UniqueUsername, String> {

    @Autowired private AppUserService appUserService;

    @Override
    public void initialize(UniqueUsername annotation) { }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return appUserService != null ? !appUserService.isHaveLogin(username) : true;
    }
}
