package com.yourcompany.simpleblogmanagement.service;

import com.yourcompany.simpleblogmanagement.model.BlogPost;

import java.util.List;

public interface BlogPostService {

    List<BlogPost> getAllPosts();

    BlogPost getPostById(Long id);

    BlogPost createPost(BlogPost post);

    BlogPost updatePost(Long id, BlogPost post);

    void deletePost(Long id);
}
