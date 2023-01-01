package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    void deleteAll();

}
