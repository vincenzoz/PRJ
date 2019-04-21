package org.vinsw.rest.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vinsw.security.entity.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id", "user.id.empty");
        ValidationUtils.rejectIfEmpty(errors, "username", "user.username.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
//        User user = (User) o;
    }
}
