package org.vinsw.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vinsw.security.builder.UserBuilder;
import org.vinsw.security.entity.User;

@RestController
public class MessageResource {

    int i = 0;
    @RequestMapping(path = "/message")
    public User getMessage() {
        System.out.println("Req: " + i++);
        User u = new UserBuilder().setId(Long.valueOf(1)).setPassword("secret").setUsername("user").build();
        return u;
    }
}
