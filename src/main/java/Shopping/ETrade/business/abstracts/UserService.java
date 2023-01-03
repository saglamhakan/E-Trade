package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.business.dtos.UserListDto;
import Shopping.ETrade.business.request.AddUserRequest;
import Shopping.ETrade.business.request.DeleteUserRequest;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;

import java.util.List;

public interface UserService {
    public Result add(AddUserRequest addUserRequest);

    DataResult<List<UserListDto>> getAll();

    //void delete();

    public void deleteByUserId(DeleteUserRequest deleteUserRequest);
}
