package com.marrios.api.dto.socialnetwork;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // gera getters, setters e toString (Lombok).
public class CreateSocialNetworkDto {
    @NotBlank(message = "O campo name é obrigatório")
    private String name;

    @NotBlank(message = "O campo socialNetworkName é obrigatório")
    private String socialNetworkName;

    @NotBlank(message = "O campo link é obrigatório")
    private String link;
}
