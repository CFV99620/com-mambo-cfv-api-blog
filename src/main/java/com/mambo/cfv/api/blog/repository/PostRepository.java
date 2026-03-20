package com.mambo.cfv.api.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mambo.cfv.api.blog.model.Post;
import com.mambo.cfv.api.blog.model.enums.PostCategory;
import com.mambo.cfv.api.blog.model.enums.PostStatus;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*
     * JpaRepository ya provee los métodos básicos, no es necesario declararlos:
     * - save(Post post) -> Guarda o actualiza un post
     * - findById(Long id) -> Busca un post por su ID (retorna Optional)
     * - findAll() -> Retorna una lista con todos los posts
     * - deleteById(Long id) -> Elimina un post por su ID
     * - count() -> Cuenta el total de posts
     * 
     * Solo declaramos métodos aquí si necesitamos búsquedas personalizadas (Query
     * Methods)
     * Ejemplo: Optional<Post> findBySlug(String slug);
     */

    List<Post> findByActiveTrueAndStatus(PostStatus status);

    List<Post> findByActiveTrueAndStatusAndFeaturedTrue(PostStatus status);

    List<Post> findByActiveTrueAndStatusAndCategoriesContaining(PostStatus status, PostCategory category);

}
