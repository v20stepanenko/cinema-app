package cinema.project.service;

import cinema.project.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
