package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponseDTO {
    @NotNull
    private String accessToken;

    @NotNull
    private String refreshToken;
}
