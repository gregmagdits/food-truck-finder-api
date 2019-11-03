package biz.pagodatech.foodtruckfinder.api.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class AppUserPrincipal extends UsernamePasswordAuthenticationToken {
    // private AppUserEntity entity;
    private String username;
    public AppUserPrincipal(Object principal, Object credentials) {
        super(principal, credentials);
    }
}