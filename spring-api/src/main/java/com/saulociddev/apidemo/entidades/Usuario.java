package com.saulociddev.apidemo.entidades;

import com.saulociddev.apidemo.enums.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private Rol rol;
    
}
