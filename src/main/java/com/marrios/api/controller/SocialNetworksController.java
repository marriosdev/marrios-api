package com.marrios.api.controller;

import com.marrios.api.dto.socialnetwork.CreateSocialNetworkDto;
import com.marrios.api.dto.socialnetwork.UpdateSocialNetworkDto;
import com.marrios.api.model.SocialNetwork;
import com.marrios.api.service.SocialNetworkService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("social-networks")
@NoArgsConstructor
public class SocialNetworksController {

    @Autowired
    private SocialNetworkService socialNetworkService;

    @GetMapping
    public ResponseEntity<List<SocialNetwork>> list() {
        return ResponseEntity.ok(this.socialNetworkService.getAll());
    }

    @PostMapping
    public ResponseEntity<SocialNetwork> create(@RequestBody @Valid CreateSocialNetworkDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.socialNetworkService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.socialNetworkService.delete(id);
        return ResponseEntity.ok("Ítem excluído com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<SocialNetwork> update(@PathVariable Long id, @RequestBody @Valid UpdateSocialNetworkDto dto) {
        SocialNetwork socialNetwork = this.socialNetworkService.update(id, dto);
        return ResponseEntity.ok(socialNetwork);
    }
}