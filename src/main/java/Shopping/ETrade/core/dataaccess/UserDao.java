package Shopping.ETrade.core.dataaccess;

import Shopping.ETrade.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
