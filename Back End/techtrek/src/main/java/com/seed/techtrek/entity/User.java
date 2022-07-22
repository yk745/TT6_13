package com.seed.techtrek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "i_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String name;
}
