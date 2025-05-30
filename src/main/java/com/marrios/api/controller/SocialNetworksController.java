package com.marrios.api.controller;

import com.marrios.api.model.SocialNetwork;
import com.marrios.api.service.SocialNetworkService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<SocialNetwork>> create() {
        return ResponseEntity.ok(this.socialNetworkService.getAll());
    }
}
