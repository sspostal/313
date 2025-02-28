package ru.kata._3.gonsoronov.dao;

import ru.kata._3.gonsoronov.model.Role;
import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);
}
