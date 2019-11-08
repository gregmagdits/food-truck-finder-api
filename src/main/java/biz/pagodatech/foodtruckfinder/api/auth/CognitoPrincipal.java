package biz.pagodatech.foodtruckfinder.api.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@RequiredArgsConstructor
public class CognitoPrincipal {
    private final UserDetails details;
}
