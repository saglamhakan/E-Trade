package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.business.dtos.UserListDto;
import Shopping.ETrade.business.request.AddUserRequest;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;

import java.util.List;

public interface UserService {
    public Result add(AddUserRequest addUserRequest);

    User findByUserName(String userName);

    User findByEmail(String email);

    DataResult<List<UserListDto>> getAll();

    void deleteById(int userId);

    DataResult <User>  getByUserId(int userId);

   // void saveUser(User user);


    void save(User user);
}
