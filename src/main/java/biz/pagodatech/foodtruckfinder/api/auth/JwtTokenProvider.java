package biz.pagodatech.foodtruckfinder.api.auth;

import biz.pagodatech.foodtruckfinder.api.exception.InvalidOrExpiredJWTToken;
import biz.pagodatech.foodtruckfinder.api.service.AppUserDetailsService;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.security.PublicKey;
import java.util.Base64;

@Component
public class JwtTokenProvider {


    private long validityInMilliseconds;
    private String jwk1;
    private AppUserDetailsService userDetailsService;

    public JwtTokenProvider(@Value("${cognito.expire:3600000}") long validityInMilliseconds, AppUserDetailsService userDetailsService) {
        this.validityInMilliseconds = validityInMilliseconds;
        this.userDetailsService = userDetailsService;
    }

    @SneakyThrows
    @PostConstruct
    protected void init() {
        //DONT COMMIT THIS!!!!!!!!!!!!
        //InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("classpath:jskset.json");
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("classpath:jskset.json");
//        String theString = IOUtils.toString(inputStream, Charset.defaultCharset());

        byte[] bytes = IOUtils.resourceToByteArray("jwkset.json", this.getClass().getClassLoader());

        //this.jwk1 = FileUtils.readFileToString(new File("jwkset.json"),Charset.defaultCharset());
        this.jwk1 = Base64.getEncoder().encodeToString(bytes);
        //get key from https://cognito-idp.us-east-1.amazonaws.com/us-east-1_MoQZph5Gu/.well-known/jwks.json
    }

//    public String createToken(String username, List<Role> roles) {
//
//        Claims claims = Jwts.claims().setSubject(username);
//        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()//
//                .setClaims(claims)//
//                .setIssuedAt(now)//
//                .setExpiration(validity)//
//                .signWith(SignatureAlgorithm.HS256, secretKey)//
//                .compact();
//    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        //check documentation for this library
        return Jwts.parser().setSigningKey(jwk1).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            //Jwts.parser().setSigningKey(jwk1).parseClaimsJws(token);


            Jwts.parser().setSigningKeyResolver(new SigningKeyResolver() {
                @Override
                public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
                    return getKey(jwsHeader);
                }

                @Override
                public Key resolveSigningKey(JwsHeader jwsHeader, String s) {
                    return getKey(jwsHeader);
                }
                private Key getKey(JwsHeader jwsHeader){
                    String keyId = jwsHeader.getKeyId(); //or any other field that you need to inspect
                    Key key = lookupVerificationKey(keyId); //implement me
                    return key;
                }
            }).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidOrExpiredJWTToken();
        }
    }

    @SneakyThrows
    private Key lookupVerificationKey(String keyId) {
//        //convert to
        PublicKey pk ;
        // final JwkStore jwkStore = new JwkStore(jwk1);
        //RSAPublicKey pk2 = new Rsa
        JwkProvider provider = new UrlJwkProvider("https://cognito-idp.us-east-1.amazonaws.com/us-east-1_MoQZph5Gu");
        Jwk jwk = provider.get(keyId); //throws Exception when not found or can't get one
        return jwk.getPublicKey();
        //com.nimbusds.jose.jwk.RSAKey jwk2 = new com.nimbusds.jose.jwk.RSAKey.parse(createJsonObject(jwk));
        //return jwk2.toPublicKey();
        //return new RSAKey();
    }

//    private JSONObject createJsonObject(Jwk jwk) {
//        JSONObject o = new JSONObject();
//        o.appendField("alg", jwk.getAlgorithm());
//    }
}
