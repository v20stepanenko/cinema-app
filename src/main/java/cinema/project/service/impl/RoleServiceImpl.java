package cinema.project.service.impl;

import cinema.project.dao.RoleDao;
import cinema.project.exception.DataProcessingException;
import cinema.project.model.Role;
import cinema.project.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getByName(roleName).orElseThrow(
                () -> new DataProcessingException("Can't find role with name " + roleName));
    }
}
