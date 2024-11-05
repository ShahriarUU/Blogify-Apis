package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = DbConstant.DbBlogComment.TABLE_NAME)
public class Comment extends Audit {

    @Column(name = DbConstant.DbBlogComment.COMMENT,nullable = false)
    private String content;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "blogPost_id")
    private BlogPost blogPost;
}
