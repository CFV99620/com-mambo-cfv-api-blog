package com.mambo.cfv.api.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mambo.cfv.api.blog.model.ExternalRecommendation;
import com.mambo.cfv.api.blog.model.enums.PostCategory;
import com.mambo.cfv.api.blog.repository.ExternalRecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final ExternalRecommendationRepository externalRecommendationRepository;

    public List<ExternalRecommendation> recommendationList() {
        return externalRecommendationRepository.findByActiveTrue();
    }

    public List<ExternalRecommendation> recommendationListByCategory(String category) {
        return externalRecommendationRepository.findByCategoriesContainingAndActiveTrue(PostCategory.valueOf(category));
    }

    public List<ExternalRecommendation> recommendationListFeatured() {
        return externalRecommendationRepository.findByFeaturedTrueAndActiveTrue();
    }

    public ExternalRecommendation recommendationSave(ExternalRecommendation recommendation) {
        return externalRecommendationRepository.save(recommendation);
    }

}
