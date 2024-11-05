package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name= DbConstant.DbUserProfile.TABLE_NAME)
public class Profile extends Audit {

    @Column(name=DbConstant.DbUserProfile.NAME)
    private String name;


    @Column(name=DbConstant.DbUserProfile.ADDRESS)
    private String address;

    @Column(name=DbConstant.DbUserProfile.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name=DbConstant.DbUserProfile.PROFESSION)
    private String profession;

    @Column(name=DbConstant.DbUserProfile.ABOUT)
    private String about;

    @Column(name=DbConstant.DbUserProfile.IMAGE)
    private String image;

    @OneToOne(mappedBy = "profile")
  //  @JsonBackReference
    private User user;

}
