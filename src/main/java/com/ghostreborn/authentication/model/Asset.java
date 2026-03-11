package com.ghostreborn.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asset {

    @Id
    private Long id;
    private String name;

}
