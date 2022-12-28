package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.core.dataaccess.UserDao;
import Shopping.ETrade.core.entities.User;
import Shopping.ETrade.core.result.Result;
import Shopping.ETrade.core.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
