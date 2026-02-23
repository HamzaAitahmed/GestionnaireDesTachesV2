package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer>{

    RefreshToken findRefreshTokenByToken(String token);

    RefreshToken findRefreshTokenById(Integer id);

    List<RefreshToken> findRefreshTokensByProprietaireDuTokenId(Integer proprietaireDuTokenId);

    List<RefreshToken> findRefreshTokensByRevoked(boolean revoked);

    List<RefreshToken> findRefreshTokensByExpiresAtBefore(LocalDateTime expiresAtBefore);

    List<RefreshToken> findRefreshTokensByExpiresAtAfter(LocalDateTime expiresAtAfter);

}
