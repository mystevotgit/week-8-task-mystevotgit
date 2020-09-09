package com.example.springtest.repository;

import com.example.springtest.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    /**
     * This method is meant to fetch all posts
     * @return
     */
    List<Post> findAll();
    void deleteById(Long id);
}
