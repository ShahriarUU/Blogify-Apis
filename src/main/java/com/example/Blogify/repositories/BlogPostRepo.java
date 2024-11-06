package com.example.Blogify.repositories;

import com.example.Blogify.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {

    List<BlogPost>findByProfileId(Long profileId);
}
