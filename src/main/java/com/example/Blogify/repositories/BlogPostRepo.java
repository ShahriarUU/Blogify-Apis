package com.example.Blogify.repositories;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Category;
import com.example.Blogify.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {

    List<BlogPost> findByUser(User user);
    List<BlogPost> findByCategory(Category category);
}
