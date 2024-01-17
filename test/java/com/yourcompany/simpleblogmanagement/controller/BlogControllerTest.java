package com.yourcompany.simpleblogmanagement.controller;

import com.yourcompany.simpleblogmanagement.model.BlogPost;
import com.yourcompany.simpleblogmanagement.service.BlogPostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class BlogControllerTest {

    @Mock
    private BlogPostService blogPostService;

    @InjectMocks
    private BlogController blogController;

    private MockMvc mockMvc;

    @Test
    public void testGetAllPosts() throws Exception {
        mockMvc = standaloneSetup(blogController).build();
        when(blogPostService.getAllPosts()).thenReturn(Arrays.asList(new BlogPost(), new BlogPost()));

        mockMvc.perform(MockMvcRequestBuilders.get("/posts/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    // Diğer test metodları da benzer şekilde implemente edilebilir
}
