package com.marrios.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="SOCIAL_NETWORKS")
@Data
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "LINK")
    private String link;

    @Column(nullable = false, name = "SOCIAL_NETWORK_NAME")
    private String socialNetworkName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialNetwork that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
