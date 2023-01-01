package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;

import java.util.List;

public interface UserService {
    public Result add(User user);

    DataResult<List<User>> getAll();

    void delete();
}
