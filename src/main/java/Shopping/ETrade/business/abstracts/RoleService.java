package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.entities.concretes.Role;
import Shopping.ETrade.result.Result;

public interface RoleService {
    Result add(String role);

    Role findByRole(String role);
}
