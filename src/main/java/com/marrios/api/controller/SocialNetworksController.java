package com.marrios.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("social-networks")
public class SocialNetworksController {

    @GetMapping
    public ResponseEntity<List<String>> list() {
        return ResponseEntity.ok(List.of("facebook"));
    }
}
