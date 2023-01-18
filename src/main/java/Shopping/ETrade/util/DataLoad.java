package Shopping.ETrade.util;

import Shopping.ETrade.dataaccess.abstracts.RoleDao;
import Shopping.ETrade.dataaccess.abstracts.UserDao;
import Shopping.ETrade.entities.concretes.Role;
import Shopping.ETrade.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoad implements ApplicationRunner {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role roleAdmin = Role.builder().roleId(1).role_name("ROLE_ADMIN").build();
        Role roleUser = Role.builder().roleId(2).role_name("ROLE_USER").build();

        roleDao.save(roleAdmin);
        roleDao.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        User admin = User.builder().userId(1).userName("Hakan").password("8001").roles(adminRoleList).build();
        userDao.save(admin);


        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User user = User.builder().userId(2).userName("Ali").password("1234").roles(userRoleList).build();
        userDao.save(user);


        System.out.println("--Roles--");
        roleDao.findAll().forEach(System.out::println);
        System.out.println("--User");
        userDao.findAll().forEach(System.out::println);

    }
}
