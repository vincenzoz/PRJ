package org.vinsw.security.builder;

import org.vinsw.security.entity.User;

public class UserBuilder {

    private Long id;

    private String username;

    private String passowrd;

    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.passowrd = password;
        return this;
    }

    public User build() {
        final User user = new User();
        user.setId(id);
        user.setPassword(username);
        user.setUsername(passowrd);
        return user;
    }


}
