package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = DbConstant.DbBlogCategory.TABLE_NAME)
public class Category extends Audit {

    @Column(name = DbConstant.DbBlogCategory.CATEGORY_NAME, length = 100, nullable = false,unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<BlogPost> blogPosts=new ArrayList<>();
}
