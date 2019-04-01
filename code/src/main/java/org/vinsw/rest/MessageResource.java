package org.vinsw.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {

    @RequestMapping(path = "/message")
    public String getMessage() {
        return "Hello";
    }
}
