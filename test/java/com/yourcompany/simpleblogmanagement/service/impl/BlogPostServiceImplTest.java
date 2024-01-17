package com.yourcompany.simpleblogmanagement.service.impl;

import com.yourcompany.simpleblogmanagement.model.BlogPost;
import com.yourcompany.simpleblogmanagement.repository.BlogPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BlogPostServiceImplTest {

    @Mock
    private BlogPostRepository blogPostRepository;

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePost() {
        BlogPost newPost = new BlogPost();
        newPost.setTitle("Test Title");
        newPost.setContent("Test Content");

        when(blogPostRepository.save(any(BlogPost.class))).thenReturn(newPost);

        BlogPost createdPost = blogPostService.createPost(newPost);

        assertNotNull(createdPost);
        assertEquals("Test Title", createdPost.getTitle());
        assertEquals("Test Content", createdPost.getContent());
        assertNotNull(createdPost.getCreatedAt());
        assertNotNull(createdPost.getUpdatedAt());
    }

    @Test
    public void testUpdatePost() {
        BlogPost existingPost = new BlogPost();
        existingPost.setId(1L);
        existingPost.setTitle("Existing Title");
        existingPost.setContent("Existing Content");
        existingPost.setCreatedAt(LocalDateTime.now().minusDays(1));
        existingPost.setUpdatedAt(LocalDateTime.now().minusDays(1));

        BlogPost updatedPost = new BlogPost();
        updatedPost.setTitle("Updated Title");
        updatedPost.setContent("Updated Content");

        when(blogPostRepository.findById(1L)).thenReturn(Optional.of(existingPost));
        when(blogPostRepository.save(any(BlogPost.class))).thenReturn(updatedPost);

        BlogPost result = blogPostService.updatePost(1L, updatedPost);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Content", result.getContent());
        assertNotNull(result.getUpdatedAt());
        assertNotEquals(existingPost.getUpdatedAt(), result.getUpdatedAt());
    }

    // Diğer test metodları da benzer şekilde implemente edilebilir
}
