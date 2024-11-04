package com.example.Blogify.entities;

import com.example.Blogify.constant.DbConstant;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public abstract class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstant.DbCommon.ID)
    private long id;

    @CreationTimestamp
    @Column(name = DbConstant.DbCommon.CREATED_ON, nullable = false, updatable = false)
    private ZonedDateTime createdOn;

    @UpdateTimestamp
    @Column(name = DbConstant.DbCommon.LAST_UPDATED_ON, nullable = false)
    private ZonedDateTime lastUpdatedOn;
}
