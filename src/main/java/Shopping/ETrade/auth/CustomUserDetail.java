package Shopping.ETrade.auth;

import Shopping.ETrade.entities.concretes.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {

        private String userName;
        private  String password;

        private List<GrantedAuthority> roles;

    public CustomUserDetail(User user){
            this.userName=user.getUserName();
            this.password=user.getPassword();
            this.roles=user.getRoles().stream().map((role -> new SimpleGrantedAuthority(role.getRole_name()))).collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
