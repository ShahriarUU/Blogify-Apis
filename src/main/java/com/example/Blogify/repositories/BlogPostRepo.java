package com.example.Blogify.repositories;

import com.example.Blogify.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost,Integer> {
}
