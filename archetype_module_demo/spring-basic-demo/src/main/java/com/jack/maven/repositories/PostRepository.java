package com.jack.maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.maven.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
