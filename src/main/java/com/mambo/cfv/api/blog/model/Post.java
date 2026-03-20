package com.mambo.cfv.api.blog.model;

import java.time.LocalDateTime;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.mambo.cfv.api.blog.model.enums.PostStatus;
import com.mambo.cfv.api.blog.model.enums.PostCategory;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PostStatus status;

    /*
     * @ElementCollection declarea que la coleccion de categorias se guardara en una
     * tabla separada pero forma parte de la entidad Post
     * 
     * @Collection Table especifica cual es la tabla donde se guardaran las
     * categorias y la columna que se une con la tabla posts
     */
    @ElementCollection(targetClass = PostCategory.class)
    @CollectionTable(name = "post_categories", joinColumns = @JoinColumn(name = "post_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    @Size(max = 4, message = "Un post no puede tener más de 4 categorías")
    @Builder.Default
    private Set<PostCategory> categories = new HashSet<>();

    /*
     * recordar que lombok, por convención para variables booleanas, dice que su
     * "getter" debe empezar con "is". Por ejemplo, si la variable se llama
     * featured, el método para obtener su valor será isFeatured(). si nombramos la
     * variable isFeatured, el getter será isIsFeatured() lo cual puede ocacionar
     * conflictos con el mapper
     */
    @Column(name = "is_featured", nullable = false)
    private boolean featured;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
