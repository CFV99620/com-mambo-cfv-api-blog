package com.mambo.cfv.api.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mambo.cfv.api.blog.model.ExternalRecommendation;
import com.mambo.cfv.api.blog.model.enums.PostCategory;

@Repository
public interface ExternalRecommendationRepository extends JpaRepository<ExternalRecommendation, Long> {
    
    // Encuentra todas las recomendaciones activas que pertenezcan a cierta categoría
    List<ExternalRecommendation> findByCategoriesContainingAndActiveTrue(PostCategory category);
    
    // Encuentra todas las recomendaciones activas destacadas (featured)
    List<ExternalRecommendation> findByFeaturedTrueAndActiveTrue();
    
}
