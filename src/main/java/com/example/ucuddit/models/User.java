package com.example.ucuddit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Integer user_id;
    private Integer Auth0_id;
    private String name;
    private String email;

    public User() {
    }

    public User(Integer user_id, Integer auth0_id, String name, String email) {
        this.user_id = user_id;
        Auth0_id = auth0_id;
        this.name = name;
        this.email = email;
    }

    public User(Integer  auth0_id, String name, String email) {
        Auth0_id = auth0_id;
        this.name = name;
        this.email = email;
    }

    public Integer  getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer  user_id) {
        this.user_id = user_id;
    }

    public Integer  getAuth0_id() {
        return Auth0_id;
    }

    public void setAuth0_id(Integer  auth0_id) {
        Auth0_id = auth0_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", Auth0_id=" + Auth0_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

