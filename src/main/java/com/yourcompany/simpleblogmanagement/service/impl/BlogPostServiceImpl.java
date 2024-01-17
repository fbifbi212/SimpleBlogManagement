package com.yourcompany.simpleblogmanagement.service.impl;

import com.yourcompany.simpleblogmanagement.model.BlogPost;
import com.yourcompany.simpleblogmanagement.repository.BlogPostRepository;
import com.yourcompany.simpleblogmanagement.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost getPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @Override
    public BlogPost createPost(BlogPost post) {
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(post);
    }

    @Override
    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        Optional<BlogPost> existingPostOptional = blogPostRepository.findById(id);
        if (existingPostOptional.isPresent()) {
            BlogPost existingPost = existingPostOptional.get();
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setUpdatedAt(LocalDateTime.now());
            return blogPostRepository.save(existingPost);
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
