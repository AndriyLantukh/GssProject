package com.su.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private long time;
    private String author;
    private String text;

    public Comment(Post post, String author, String text) {
        this.post = post;
        this.time = new Date().getTime();
        this.author = author;
        this.text = text;
    }
}
