package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User("Anton1", "anton1@gmail.com", "123", Role.ROLE_USER),
            new User("Anton2", "anton2@gmail.com", "456", Role.ROLE_USER),
            new User("Anton3", "anton3@gmail.com", "788", Role.ROLE_USER),
            new User("Anton4", "anton4@gmail.com", "561", Role.ROLE_USER),
            new User("Anton5", "anton5@gmail.com", "654", Role.ROLE_USER)
    );

    public static List<User> getUsers(Collection<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }
}
