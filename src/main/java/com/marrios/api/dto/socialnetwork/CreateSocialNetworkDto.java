package com.marrios.api.dto.socialnetwork;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateSocialNetworkDto {

    @NotBlank(message = "O campo socialNetworkName é obrigatório")
    private String socialNetworkName;

    @NotBlank(message = "O campo link é obrigatório")
    @URL(message = "O campo link deve ser uma URL válida")
    private String link;
}
