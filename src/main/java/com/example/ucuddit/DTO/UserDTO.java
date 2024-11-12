package com.example.ucuddit.DTO;

public class UserDTO {

    private Integer userId;
    private String auth0id;
    private String name;
    private String email;
    private String imageUrl;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String auth0id, String name, String email, String imageUrl) {
        this.userId = userId;
        this.auth0id = auth0id;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
