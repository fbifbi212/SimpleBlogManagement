package com.yourcompany.simpleblogmanagement.repository;

import com.yourcompany.simpleblogmanagement.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
