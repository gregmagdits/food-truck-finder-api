package biz.pagodatech.foodtruckfinder.api.auth.provider;


import biz.pagodatech.foodtruckfinder.api.auth.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {

    private JwtTokenProvider tokenProvider;

    //https://github.com/oktadeveloper/okta-java-jwt-example/blob/master/src/main/java/com/okta/createverifytokens/JWTDemo.java
    public static Claims decodeJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
//                .parseClaimsJws(jwt).getBody();
//        return claims;
        return null;

    }


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        tokenProvider.getAuthentication(auth.getCredentials().toString());

        String username = auth.getName();
        String password = auth.getCredentials().toString();

        if ("externaluser".equals(username) && "pass".equals(password)) {
            return new UsernamePasswordAuthenticationToken(null, null, null);
        } else {
            throw new BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
