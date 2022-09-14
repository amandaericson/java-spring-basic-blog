package com.pluralsight.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepo){
        this.postRepository = postRepo;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelmap) {
        List<Post> posts = postRepository.getAllPosts();
        modelmap.put("posts", posts);
        return "home";
    }
}
