package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = DbConstant.DbUserProfile.TABLE_NAME)
public class Profile extends Audit {

    @Column(name = DbConstant.DbUserProfile.NAME,nullable = false,length = 100)
    private String name;


    @Column(name = DbConstant.DbUserProfile.ADDRESS,nullable = false,length = 100)
    private String address;

    @Column(name = DbConstant.DbUserProfile.PHONE_NUMBER,unique = true)
    private String phoneNumber;

    @Column(name = DbConstant.DbUserProfile.PROFESSION,nullable = false)
    private String profession;

    @Column(name = DbConstant.DbUserProfile.ABOUT,nullable = false)
    private String about;

    @Column(name = DbConstant.DbUserProfile.IMAGE)
    private String image;

    @OneToOne(mappedBy = "profile",fetch = FetchType.LAZY)
    //  @JsonBackReference
    private User user;



}
