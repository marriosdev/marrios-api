package com.marrios.api.model;

import jakarta.persistence.*;

@Entity
@Table(name="SOCIAL_NETWORKS")
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String socialNetworkName;
}
