package com.example.ortiz.ProyectoIntegrador.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private Long id;
    private String username;
    private String email;

    public Long getId() {
        return this.id;
    }

    public void setId(Long aLong) {
        this.id=aLong;
    }
    // otros campos que puedas necesitar

    // Constructores, getters y setters
}
