package ru.kata._3.gonsoronov.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata._3.gonsoronov.model.Role;
import ru.kata._3.gonsoronov.model.User;
import ru.kata._3.gonsoronov.service.RoleService;
import ru.kata._3.gonsoronov.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Ordinary {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Ordinary(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);

        User admin = new User("Sergei",
                "Gonsoronov", (byte) 21,
                "gonsoronss@icloud.com",
                "admin",
                "admin",adminSet);
        User newUser = new User("Pat",
                "Holman", (byte) 29,
                "3friends@mail.ru",
                "user",
                "user", userSet);

        userService.saveUser(newUser);
        userService.saveUser(admin);
    }
}
