package com.marrios.api.dto.socialnetwork;

import lombok.Data;

@Data // gera getters, setters e toString (Lombok).
public class CreateSocialNetworkDto {
    private String name;
    private String socialNetworkName;
    private String link;
}
