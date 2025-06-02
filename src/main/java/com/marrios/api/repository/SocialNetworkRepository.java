package com.marrios.api.repository;

import com.marrios.api.model.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long> {
    @Query("SELECT COUNT(s) > 0 FROM SocialNetwork s WHERE s.socialNetworkName = :name")
    boolean existsByName(@Param("name") String name);

    Optional<SocialNetwork> findById(Long id);
}
