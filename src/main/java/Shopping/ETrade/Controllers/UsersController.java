package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.core.dataaccess.UserDao;
import Shopping.ETrade.core.entities.User;
import Shopping.ETrade.core.result.ErrorDataResult;
import Shopping.ETrade.core.result.Result;
import Shopping.ETrade.core.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController implements UserService {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/UserName")
    public Result add(@RequestBody User user) {
        return this.userService.add(user);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, false, "Validation errors");
        return errors;
    }
}
