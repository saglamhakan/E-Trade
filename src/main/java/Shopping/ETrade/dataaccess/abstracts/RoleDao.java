package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.Role;
import Shopping.ETrade.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {

    Role save(Role roleAdmin);
    Role findByRole(String role);
}
