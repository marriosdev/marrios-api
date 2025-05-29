package com.marrios.api.controller;

import com.marrios.api.service.SocialNetworkService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("social-networks")
public class SocialNetworksController {

    // TODO Implementar busca de redes sociais pelo service
    @GetMapping
    public ResponseEntity<List<String>> list() {
        return ResponseEntity.ok(List.of("facebook"));
    }
}
