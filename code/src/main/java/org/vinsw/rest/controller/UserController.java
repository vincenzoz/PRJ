package org.vinsw.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.vinsw.rest.CommonResponse;
import org.vinsw.rest.validator.UserValidator;
import org.vinsw.security.builder.UserBuilder;
import org.vinsw.security.entity.User;

import static org.springframework.util.Assert.notNull;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController {

    @Autowired
    UserValidator validator;

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        System.out.println("param: userId:" + userId);
        return mockedUser();
    }

    @PostMapping()
    public ResponseEntity<CommonResponse> addUser(@RequestBody User user, BindingResult bindingResult) {
        notNull(user, "User not valid!");
        validator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return invalid(bindingResult);
        }
        return success();
    }

    private static User mockedUser() {
        return new UserBuilder().setId(Long.valueOf(1)).setPassword("secret").setUsername("user").build();
    }
}
