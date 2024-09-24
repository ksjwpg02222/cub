package com.cub.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "modified_user")
    private String modifiedUser;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    public void create(String account) {
        this.createdUser = account;
        this.createdDate = Timestamp.valueOf(LocalDateTime.now());
        this.modifiedUser = getCreatedUser();
        this.modifiedDate = getCreatedDate();
    }

    public void update(String account) {
        this.modifiedUser = account;
        this.modifiedDate = Timestamp.valueOf(LocalDateTime.now());
    }

}
