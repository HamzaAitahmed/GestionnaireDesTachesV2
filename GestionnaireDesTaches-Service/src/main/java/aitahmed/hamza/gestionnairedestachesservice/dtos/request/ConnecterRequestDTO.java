package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnecterRequestDTO {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
