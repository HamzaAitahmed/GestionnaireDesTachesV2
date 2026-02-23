package aitahmed.hamza.gestionnairedestachesservice.authentification;

import aitahmed.hamza.gestionnairedestachesservice.entity.RefreshToken;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    TokenService(RefreshTokenRepository refreshTokenRepository)
    {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public void saveToken(Utilisateur utilisateuir, String refreshToken)
    {
        RefreshToken token = new RefreshToken();
        token.setExpiresAt(LocalDateTime.now().plusDays(7));
        token.setProprietaireDuToken(utilisateuir);
        token.setRevoked(false);
        token.setCreatedAt(LocalDateTime.now());
        token.setToken(refreshToken);
        try
        {
            refreshTokenRepository.save(token);
        }catch (Exception e)
        {
            throw new RuntimeException("!!! Token Not Saved !!!");
        }
    }

    public void deleteToken(RefreshToken refreshToken)
    {
        try
        {
            refreshTokenRepository.delete(refreshToken);
        }catch (Exception e)
        {
            throw new RuntimeException("!!! Token Not Deleted Duo !!!");
        }
    }

    public void revokedToken(String refreshToken, boolean status)
    {
        RefreshToken token = refreshTokenRepository.findRefreshTokenByToken(refreshToken);
        if(token.getExpiresAt().isBefore(LocalDateTime.now()) )
        {
            deleteToken(token);
            return ;
        }
        revokedStatus(token, status);
    }

    public void revokedStatus(RefreshToken refreshToken, boolean status)
    {
        refreshToken.setRevoked(status);
        try
        {
            refreshTokenRepository.save(refreshToken);
        }catch (Exception e)
        {
            throw new RuntimeException("!!! Token Not Saved !!!");
        }
    }

    public boolean validateRefreshToken(String token) {

        // Validate in DB
        RefreshToken storedRefreshToken = refreshTokenRepository.findRefreshTokenByToken(token);

        if (storedRefreshToken.isRevoked()) {
            return false;
        }

        if (storedRefreshToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            return false;
        }

        return true;
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
