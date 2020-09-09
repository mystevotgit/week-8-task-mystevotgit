package com.example.springtest.servicesimpl;

import com.example.springtest.models.Post;
import com.example.springtest.repository.PostRepository;
import com.example.springtest.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public void SavePostData(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> FindAllPosts() {
        List<Post> list = postRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    @Override
    public void DeletePostData(Long id) {
        System.out.println(id + "is to be deleted");
        postRepository.deleteById(id);
    }

    @Override
    public void UpdatePostData(Post post) {
        postRepository.save(post);
    }

    @Override
    public Optional<Post> FindPostData(Long id) {
        return postRepository.findById(id);
    }


}
