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

    /**
     * This is the fetch all post implementation method
     * @return
     */
    @Override
    public List<Post> FindAllPosts() {
        List<Post> list = postRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    /**
     * This is the delete post implementation method
     * @param id
     */
    @Override
    public void DeletePostData(Long id) {
        System.out.println(id + "is to be deleted");
        postRepository.deleteById(id);
    }

    /**
     * This is the post update implementation method
     * @param post
     */
    @Override
    public void UpdatePostData(Post post) {
        postRepository.save(post);
    }

    /**
     * This method is the implementation of selecting a post by id
     * @param id
     * @return
     */
    @Override
    public Optional<Post> FindPostData(Long id) {
        return postRepository.findById(id);
    }


}
