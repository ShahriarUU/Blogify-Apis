package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = DbConstant.DbBlogPost.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class BlogPost extends Audit {

    @Column(name = DbConstant.DbBlogPost.TITLE,nullable = false)
    private String title;
    @Column(name = DbConstant.DbBlogPost.IMAGE)
    private String image;
    @Column(name = DbConstant.DbBlogPost.CONTENT,nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "blogPost",cascade = CascadeType.ALL)
    private List<Comment> comment;
}
