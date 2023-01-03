package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.business.dtos.ProductListDto;
import Shopping.ETrade.business.dtos.UserListDto;
import Shopping.ETrade.business.request.AddProductRequest;
import Shopping.ETrade.business.request.AddUserRequest;
import Shopping.ETrade.business.request.DeleteUserRequest;
import Shopping.ETrade.dataaccess.abstracts.ProductsDao;
import Shopping.ETrade.dataaccess.abstracts.UserDao;
import Shopping.ETrade.entities.concretes.Category;
import Shopping.ETrade.entities.concretes.Product;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    private final ProductsDao productsDao;

    @Autowired
    public UserManager(UserDao userDao,
                       ProductsDao productsDao) {
        this.userDao = userDao;
        this.productsDao = productsDao;
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
    public void deleteByUserId(DeleteUserRequest deleteUserRequest) {
        User user = this.convertDeleteUserRequestToUser(deleteUserRequest);
        productsDao.deleteById(deleteUserRequest.getUserId());
    }




  /*  @Override
    public void delete() {
        userDao.deleteAll();
    }

*/

    private User convertAddUserRequestToUser(AddUserRequest adduserRequest) {
        User user = new User();

        user.setName(adduserRequest.getName());
        user.setEmail(adduserRequest.getEmail());
        user.setPassword(adduserRequest.getPassword());

        return user;
    }

    private boolean validateRequest(AddUserRequest addUserRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(addUserRequest.getName())) {
            isSuccess = false;
        }
        return isSuccess;
    }

    private UserListDto convertUserToUserListDto(User user) {
        UserListDto userListDto = new UserListDto();

        userListDto.setName(user.getName());
        userListDto.setEmail(user.getEmail());
        userListDto.setPassword(user.getPassword());


        return userListDto;
    }

    private User convertDeleteUserRequestToUser(DeleteUserRequest deleteUserRequest) {
        User user = new User();

        user.setUserId(deleteUserRequest.getUserId());

        return user;

    }
}

