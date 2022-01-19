package cinema.project.config;

import cinema.project.model.Role;
import cinema.project.model.User;
import cinema.project.service.RoleService;
import cinema.project.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInjector {
    private final RoleService roleService;
    private final UserService userService;

    public DataInjector(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@google.com");
        user.setPassword("password");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
