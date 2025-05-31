package com.marrios.api.service;

import com.marrios.api.dto.socialnetwork.CreateSocialNetworkDto;
import com.marrios.api.exception.socialnetwork.SocialNetworkAlreadyExistsException;
import com.marrios.api.model.SocialNetwork;
import com.marrios.api.repository.SocialNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SocialNetworkService {

    @Autowired
    private SocialNetworkRepository socialNetworkRepository;

    public List<SocialNetwork> getAll()
    {
        return socialNetworkRepository.findAll();
    }

    public SocialNetwork create(CreateSocialNetworkDto dto) throws SocialNetworkAlreadyExistsException {
        if (socialNetworkRepository.existsByName(dto.getSocialNetworkName())) {
            throw new SocialNetworkAlreadyExistsException(
                    dto.getSocialNetworkName()
            );
        }

        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setSocialNetworkName(dto.getSocialNetworkName());
        socialNetwork.setLink(dto.getLink());
        return socialNetworkRepository.save(socialNetwork);
    }
}
