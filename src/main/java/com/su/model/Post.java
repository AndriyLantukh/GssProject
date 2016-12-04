package com.su.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString
public class Post {

    //   private static AtomicLong counter = new AtomicLong();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //  private long id = counter.getAndIncrement();
    private String url;
    private int likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public Post(String url) {
        this.url = url;
    }


//    private List<Comment> comments = new ArrayList<>();

//    public Post(String url, String... comments) {
//
//        this.url = url;
//        this.comments = Arrays.stream(comments)
//                .map(s -> new Comment("System", s))
//                .collect(Collectors.toList());
//    }
}