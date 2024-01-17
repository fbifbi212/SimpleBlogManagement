package com.yourcompany.simpleblogmanagement.service;

import com.yourcompany.simpleblogmanagement.model.BlogPost;
import com.yourcompany.simpleblogmanagement.repository.BlogPostRepository;
import com.yourcompany.simpleblogmanagement.service.impl.BlogPostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BlogPostServiceTest {

    @Mock
    private BlogPostRepository blogPostRepository;

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPosts() {
        when(blogPostRepository.findAll()).thenReturn(Arrays.asList(new BlogPost(), new BlogPost()));
        assertEquals(2, blogPostService.getAllPosts().size());
    }

    // Diğer test metodları da benzer şekilde implemente edilebilir
}
