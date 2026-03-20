package com.mambo.cfv.api.blog.service;

import com.mambo.cfv.api.blog.model.Post;
import com.mambo.cfv.api.blog.model.enums.PostStatus;
import com.mambo.cfv.api.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mambo.cfv.api.blog.model.enums.PostCategory;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Optional<Post> findByPostId(Long id) {
        return postRepository.findById(id);
    }

    public Post postSave(Post post) {
        return postRepository.save(post);
    }

    public List<Post> postList() {
        return postRepository.findByActiveTrueAndStatus(PostStatus.PUBLISHED);
    }

    public List<Post> postListFeatured() {
        return postRepository.findByActiveTrueAndStatusAndFeaturedTrue(PostStatus.PUBLISHED);
    }

    public List<Post> postListByCategory(String category) {
        return postRepository.findByActiveTrueAndStatusAndCategoriesContaining(PostStatus.PUBLISHED,
                PostCategory.valueOf(category));
    }
}
