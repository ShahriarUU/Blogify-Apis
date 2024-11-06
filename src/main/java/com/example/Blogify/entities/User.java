package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = DbConstant.DbUser.ROLE,nullable = false)
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile")
    // @JsonManagedReference
    private Profile profile;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();


}
