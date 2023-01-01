package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.entities.concretes.User;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.ErrorDataResult;
import Shopping.ETrade.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController implements UserService {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        return this.userService.add(user);
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @Override
    public void delete() {

    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser() {
        userService.delete();
        return ResponseEntity.ok().build();

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,  "Validation errors");
        return errors;
    }
}
