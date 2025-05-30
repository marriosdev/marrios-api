package com.marrios.api.controller;

import com.marrios.api.dto.socialnetwork.CreateSocialNetworkDto;
import com.marrios.api.model.SocialNetwork;
import com.marrios.api.service.SocialNetworkService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("social-networks")
public class SocialNetworksController {

    private SocialNetworkService socialNetworkService;

    public SocialNetworksController(SocialNetworkService socialNetworkService) {
        this.socialNetworkService = socialNetworkService;
    }

    @GetMapping
    public ResponseEntity<List<SocialNetwork>> list() {
        return ResponseEntity.ok(this.socialNetworkService.getAll());
    }

    @PostMapping
    public ResponseEntity<CreateSocialNetworkDto> create(@RequestBody @Valid CreateSocialNetworkDto createSocialNetworkDto) {
        return ResponseEntity.ok(createSocialNetworkDto);
    }
}
