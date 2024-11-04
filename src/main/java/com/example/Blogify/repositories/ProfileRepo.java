package com.example.Blogify.repositories;

import com.example.Blogify.entities.Profile;
import com.example.Blogify.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {

}
