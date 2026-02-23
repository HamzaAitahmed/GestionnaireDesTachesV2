package aitahmed.hamza.gestionnairedestachesservice.authentification;

import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final TokenService tokenService;
    @Value("${jwt.secret}")
    private String secret;

    public JwtService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(Utilisateur utilisateur) {

        return Jwts.builder()
                .setSubject(utilisateur.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 min
                .signWith(getSigningKey())
                .compact();
    }

    public String generateRefreshToken(Utilisateur utilisateur) {

        return Jwts.builder()
                .setSubject(utilisateur.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30)) // 30 days
                .signWith(getSigningKey())
                .compact();
    }

    public boolean isTokenValid(String token, Utilisateur utilisateur) {

        // Validate in DB
        if( !tokenService.validateRefreshToken(token) )
        {
            return false;
        }

        // Extract user from JWT
        String email = extractEmail(token);

        return email.equals(utilisateur.getEmail()) && !isTokenExpired(token);
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Date extractIssued(String token) {
        return getClaims(token).getIssuedAt();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    protected void revokeToken(String token)
    {
        tokenService.revokedToken(token, true);
    }

    protected void saveToken(Utilisateur utilisateur, String refreshToken)
    {
        tokenService.saveToken(utilisateur, refreshToken);
    }

}

//        | Situation            | Action         |
//        | -------------------- | -------------- |
//        | Logout               | Revoke         |
//        | Refresh rotation     | Revoke old     |
//        | Password change      | Revoke all     |
//        | Admin block          | Revoke all     |
//        | Cleanup job          | Delete expired |
//        | User account deleted | Delete all     |
