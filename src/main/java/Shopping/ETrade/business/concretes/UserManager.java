package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.business.dtos.UserListDto;
import Shopping.ETrade.business.request.AddUserRequest;
import Shopping.ETrade.dataaccess.abstracts.ProductsDao;
import Shopping.ETrade.dataaccess.abstracts.RoleDao;
import Shopping.ETrade.dataaccess.abstracts.UserDao;
import Shopping.ETrade.entities.concretes.Role;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    private final ProductsDao productsDao;
    private final RoleDao roleDao;


    @Autowired
    public UserManager(UserDao userDao,
                       ProductsDao productsDao,
                       RoleDao roleDao) {
        this.userDao = userDao;
        this.productsDao = productsDao;
        this.roleDao = roleDao;
    }

    @Override
    public Result add(AddUserRequest addUserRequest) {
        if (this.validateRequest(addUserRequest)) {
            User user = this.convertAddUserRequestToUser(addUserRequest);
            userDao.save(user);

            return new SuccessResult("User added");
        } else {
            return new ErrorResult("User not added");
        }

    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByUserName(email);
    }

    public void save(User user) {
        user.setRoles(Arrays.asList(roleDao.findByRole("USER")));
        user.setEnabled(true);
        userDao.save(user);


    }

    @Override
    public DataResult<List<UserListDto>> getAll() {
        List<User> users = userDao.findAll();
        List<UserListDto> userListDtoList = new ArrayList<>();

        for (User user : users) {
            UserListDto userListDto = new UserListDto();
            userListDto = this.convertUserToUserListDto(user);

            userListDtoList.add(userListDto);
        }
        return new SuccessDataResult<List<UserListDto>>(userListDtoList, "Users listed");
    }

    @Override
    public void deleteById(int userId) {
        this.userDao.deleteById(userId);

    }


    @Override
    public DataResult<User> getByUserId(int userId) {
        return new SuccessDataResult<User>(
                this.userDao.getByUserId(userId).getData());
    }


    private User convertAddUserRequestToUser(AddUserRequest adduserRequest) {
        User user = new User();

        user.setFirstName(adduserRequest.getFirstName());
        user.setLastName(adduserRequest.getLastName());
        user.setUserName(adduserRequest.getUserName());
        user.setEmail(adduserRequest.getEmail());
        user.setPassword(adduserRequest.getPassword());
        user.setUserId(adduserRequest.getUserId());

        return user;
    }

    private boolean validateRequest(AddUserRequest addUserRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(addUserRequest.getUserName())) {
            isSuccess = false;
        }
        return isSuccess;
    }

    private UserListDto convertUserToUserListDto(User user) {
        UserListDto userListDto = new UserListDto();

        userListDto.setFirstName(user.getFirstName());
        userListDto.setLastName(user.getLastName());
        userListDto.setUserName(user.getUserName());
        userListDto.setEmail(user.getEmail());
        userListDto.setPassword(user.getPassword());
        userListDto.setUserId(user.getUserId());

        return userListDto;
    }


}

