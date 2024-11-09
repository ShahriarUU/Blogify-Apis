package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import com.example.Blogify.entities.Enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = DbConstant.DbUser.TABLE_NAME)
public class User extends Audit {


    @Column(name = DbConstant.DbUser.EMAIL,nullable = false,unique = true)
    private String email;

    @Column(name = DbConstant.DbUser.PASSWORD,nullable = false,length = 20)
    private String password;


    @Enumerated(value=EnumType.STRING)
    @Column(name = DbConstant.DbUser.ROLE,nullable = false)
    private UserRole role;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile")
    // @JsonManagedReference
    private Profile profile;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<BlogPost> blogPosts = new ArrayList<>();


}
