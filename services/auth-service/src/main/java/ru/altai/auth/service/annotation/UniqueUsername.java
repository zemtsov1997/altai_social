package ru.altai.auth.service.annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidatorUniqueUsername.class})
public @interface UniqueUsername {

    String message() default "error.accaunt.login.unique";

    Class[] groups() default {};

    Class[] payload() default {};

}
