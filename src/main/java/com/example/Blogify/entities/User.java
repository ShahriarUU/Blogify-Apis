package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = DbConstant.DbUser.TABLE_NAME)
public class User extends  Audit{


    @Column(name= DbConstant.DbUser.EMAIL )
    private String email;

    @Column(name=DbConstant.DbUser.PASSWORD)
    private String password;

    @Column(name=DbConstant.DbUser.ROLE)
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_profile")
   // @JsonManagedReference
    private Profile profile;

}
