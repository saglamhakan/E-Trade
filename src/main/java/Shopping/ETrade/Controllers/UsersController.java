package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.UserService;
import Shopping.ETrade.business.dtos.UserListDto;
import Shopping.ETrade.business.request.AddUserRequest;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {


    @Autowired
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admine özel mesajdır";
    }

    @GetMapping("/index")
    public String index() {
        return "Index Sayfası, Hoşgeldiniz";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Login başarılı, dashboard sayfası";
    }


    @PostMapping("/add")
    public Result add(@RequestBody AddUserRequest addUserRequest) {
        return this.userService.add(addUserRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<UserListDto>> getAll() {
        return this.userService.getAll();

    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int userId) {
        this.userService.deleteById(userId);
    }


}
