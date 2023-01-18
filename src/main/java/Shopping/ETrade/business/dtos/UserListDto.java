package Shopping.ETrade.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListDto {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private int userId;


}
