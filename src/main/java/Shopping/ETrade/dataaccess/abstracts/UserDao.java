package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByEmail(String email);

    DataResult<User> getByUserId(int userId);

    void deleteById(int userId);

    User findByName(String username);

    //  void saveUser(User user);
}