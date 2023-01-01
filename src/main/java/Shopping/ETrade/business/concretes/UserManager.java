package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.dataaccess.abstracts.UserDao;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import Shopping.ETrade.result.SuccessDataResult;
import Shopping.ETrade.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager (UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User listed");
    }

    @Override
    public void delete() {
        userDao.deleteAll();
    }


}
