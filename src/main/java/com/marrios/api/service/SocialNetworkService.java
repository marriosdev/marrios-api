package com.marrios.api.service;

import com.marrios.api.model.SocialNetwork;
import com.marrios.api.repository.SocialNetworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialNetworkService {

    private final SocialNetworkRepository socialNetworkRepository;

    public SocialNetworkService(SocialNetworkRepository socialNetworkRepository) {
            this.socialNetworkRepository = socialNetworkRepository;
    }

    public List<SocialNetwork> getAll()
    {
        return socialNetworkRepository.findAll();
    }
}
