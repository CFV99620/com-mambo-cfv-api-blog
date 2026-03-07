package com.mambo.cfv.api.blog.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter // crea getters
@Setter // crea setters
@NoArgsConstructor // crea constructor sin argumentos
@AllArgsConstructor // crea constructor con todos los argumentos
@Builder // crea constructores, getters, setters, etc
public class Post {

    @Id // indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que se autogenera
    private Long id;

    @Column(name = "title", nullable = false) // indica que es una columna y no puede ser nula
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
