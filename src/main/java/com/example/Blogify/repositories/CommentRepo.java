package com.example.Blogify.repositories;

import com.example.Blogify.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
