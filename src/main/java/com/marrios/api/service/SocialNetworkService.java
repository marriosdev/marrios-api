package com.marrios.api.service;

import com.marrios.api.dto.socialnetwork.CreateSocialNetworkDto;
import com.marrios.api.dto.socialnetwork.UpdateSocialNetworkDto;
import com.marrios.api.exception.socialnetwork.SocialNetworkAlreadyExistsException;
import com.marrios.api.kafka.producer.socialnetwork.SocialNetworkProducer;
import com.marrios.api.model.SocialNetwork;
import com.marrios.api.repository.SocialNetworkRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SocialNetworkService {

    @Autowired
    private SocialNetworkRepository socialNetworkRepository;

    @Autowired
    private SocialNetworkProducer socialNetworkProducer;

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

        // KAFKA MESSAGE
        System.out.println("ENVIANDO MENSAGEM PARA O KAFKA");
        this.socialNetworkProducer.createSocialNetworkMessage("Social Networok - Created: " + dto.getLink());

        return socialNetworkRepository.save(socialNetwork);
    }

    public boolean delete(Long id) {
        SocialNetwork socialNetwork = socialNetworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SocialNetwork não encontrada: " + id));
        this.socialNetworkRepository.delete(socialNetwork);
        return true;
    }

    @Transactional
    public SocialNetwork update(Long id, UpdateSocialNetworkDto dto) {
        SocialNetwork socialNetwork = this.socialNetworkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ítem não encontrado."));

        socialNetwork.setLink(dto.getLink());
        socialNetwork.setSocialNetworkName(dto.getSocialNetworkName());

        this.socialNetworkRepository.save(socialNetwork);
        return socialNetwork;
    }
}
