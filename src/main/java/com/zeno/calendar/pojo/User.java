package com.zeno.calendar.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "This is user")
public class User {
    @ApiModelProperty(hidden = true)
    private String id;

    private String email;

    @ApiModelProperty(value = "Password", name = "password", example = "123456", required = true)
    private String password;

    @ApiModelProperty(value = "Username", name = "username", example = "zwx0641", required = true)
    private String username;

    @ApiModelProperty(hidden = true)
    private String face_image;

    /**
     * @return face_image
     */
    public String getFace_image() {
        return face_image;
    }

    /**
     * @param face_image
     */
    public void setFace_image(String face_image) {
        this.face_image = face_image;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}