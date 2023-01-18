package Shopping.ETrade.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private int userId;


}
