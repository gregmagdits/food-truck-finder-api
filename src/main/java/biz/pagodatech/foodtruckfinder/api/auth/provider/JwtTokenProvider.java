package biz.pagodatech.foodtruckfinder.api.auth.provider;

import biz.pagodatech.foodtruckfinder.api.exception.InvalidOrExpiredJWTToken;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Collections;

@Component
public class JwtTokenProvider {

    @Value("${cognito.jwk_url}") private String jwkUrl;

    public Authentication getAuthentication(String token) {
        Jws<Claims> claims = getClaims(token);
        String username = claims.getBody().getSubject();

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("N/A")
                .authorities(Collections.emptyList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Jws<Claims> getClaims(String token) {
        try {
            return Jwts.parser().setSigningKeyResolver(new SigningKeyResolver() {
                @Override
                public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
                    return getKey(jwsHeader);
                }

                @Override
                public Key resolveSigningKey(JwsHeader jwsHeader, String s) {
                    return getKey(jwsHeader);
                }

                @SneakyThrows
                private Key getKey(JwsHeader jwsHeader){
                    String keyId = jwsHeader.getKeyId(); //or any other field that you need to inspect
                    JwkProvider provider = new UrlJwkProvider(jwkUrl);
                    return provider.get(keyId).getPublicKey(); //throws Exception when not found or can't get one
                }
            }).parseClaimsJws(token);
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidOrExpiredJWTToken();
        }
    }
}
