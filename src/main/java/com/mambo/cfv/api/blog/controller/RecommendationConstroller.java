package com.mambo.cfv.api.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mambo.cfv.api.blog.model.ExternalRecommendation;
import com.mambo.cfv.api.blog.model.enums.PostCategory;
import com.mambo.cfv.api.blog.service.RecommendationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationConstroller {

    private final RecommendationService recommendationService;

    public RecommendationConstroller(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/list")
    public List<ExternalRecommendation> allRecommendations() {
        log.info("[RecommendationConstroller] Buscando todas las recomendaciones");
        return recommendationService.recommendationList();
    }

    @GetMapping("/list/category/{category}")
    public List<ExternalRecommendation> allRecommendationsByCategory(@PathVariable("category") String category) {
        log.info("[RecommendationConstroller] Buscando todas las recomendaciones de la categoría: {}", category);
        return recommendationService.recommendationListByCategory(category);
    }

    @GetMapping("/list/featured")
    public List<ExternalRecommendation> allRecommendationsFeatured() {
        log.info("[RecommendationConstroller] Buscando todas las recomendaciones destacadas");
        return recommendationService.recommendationListFeatured();
    }

}
