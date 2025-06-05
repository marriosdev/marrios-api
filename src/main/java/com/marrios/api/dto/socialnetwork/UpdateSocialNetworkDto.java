package com.marrios.api.dto.socialnetwork;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class UpdateSocialNetworkDto {
    private String socialNetworkName;

    @URL(message = "O campo link deve ser uma URL válida")
    private String link;
}
