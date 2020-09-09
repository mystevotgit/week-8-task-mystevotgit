package com.example.springtest.services;

import com.example.springtest.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    public void SavePostData(Post post);
    public List<Post> FindAllPosts();
    public void DeletePostData(Long id);
    public void UpdatePostData(Post post);
    public Optional<Post> FindPostData(Long id);
}
