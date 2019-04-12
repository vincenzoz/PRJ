package org.vinsw.java8.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.vinsw.security.builder.UserBuilder;
import org.vinsw.security.entity.User;

public class StreamMain {

    public static void main(String[] args) {

        List<User> userList = new LinkedList<>();

        userList.add(new UserBuilder().setId(new Long(1)).setUsername("user1").setPassword("passw1").build());
        userList.add(new UserBuilder().setId(new Long(2)).setUsername("user2").setPassword("passw2").build());
        userList.add(new UserBuilder().setId(new Long(3)).setUsername("user3").setPassword("passw3").build());
        userList.add(new UserBuilder().setId(new Long(4)).setUsername("user4").setPassword("passw4").build());


        userList.stream().map(User::getUsername).collect(Collectors.toList());

        for (User u: userList) {
            System.out.println(u.toString());
        }





    }
}
