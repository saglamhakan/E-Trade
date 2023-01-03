package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.business.request.DeleteUserRequest;
import Shopping.ETrade.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    void deleteByUserId(DeleteUserRequest deleteUserRequest);

    //void deleteAll();

}
