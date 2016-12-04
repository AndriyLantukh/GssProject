package com.su;

import com.su.model.Comment;
import com.su.model.Post;
import com.su.repository.CommentRepository;
import com.su.repository.PostRepository;
import com.su.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    PostRepository postRepo;

    @Autowired
    CommentRepository commentRepo;

    //   private List<Post> posts = new CopyOnWriteArrayList<>();

//    @PostConstruct
//    public void generate() {
//        posts.add(new Post("http://wfiles.brothersoft.com/m/mac-os-x-lake_88093-800x600.jpg"));
//        posts.add(new Post("https://tl.5ko.fr/uploads/T/Fractal_Broccoli.jpg"));
//        posts.add(new Post("http://iipix.com/wallpaper/pics/katasunsethor800.jpg", "This one is nice!"));
//    }

    @RequestMapping("/posts")
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        postRepo.findAll().forEach(post -> posts.add(post));
        return posts;
    }


    @RequestMapping("/post/{id}")
    public Post getPost(@PathVariable long id) {
        return postRepo.findOne(id);
  //      return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = "text/plain")
    public void post(@RequestBody String url) throws UnsupportedEncodingException {
        postRepo.save(new Post(url));
    }

    @RequestMapping(value = "/post/delete/{id}", method = RequestMethod.POST)
    public void deletePost(@PathVariable long id) {
        postRepo.delete(id);
 //       posts = posts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
    }

    @RequestMapping(value = "/post/like/{id}", method = RequestMethod.POST)
    public void like(@PathVariable long id) {
        Post postToLike = postRepo.findOne(id);
        if(postToLike != null) {
            postToLike.setLikes(postToLike.getLikes() + 1);
            postRepo.save(postToLike);
        }
//        posts.stream().filter(p -> p.getId() == id).findFirst().ifPresent(p -> p.setLikes(p.getLikes() + 1));
    }

    @RequestMapping(value = "/post/message", method = RequestMethod.POST)
    public void message(@RequestBody CommentReq c) {
        Post postToAddComment = postRepo.findOne(c.getId());
        if(postToAddComment != null) {
            Comment newComment = new Comment(postToAddComment, c.getAuthor(), c.getText());
            commentRepo.save(newComment);
        }
 //      posts.stream().filter(p -> p.getId() == c.getId()).findFirst().ifPresent(p -> p.getComments().add(comment));
    }
}

@Data
class CommentReq {
    private long id;
    private String author;
    private String text;
}