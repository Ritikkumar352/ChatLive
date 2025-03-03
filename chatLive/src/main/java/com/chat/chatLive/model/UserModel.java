package com.chat.chatLive.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(nullable=false, unique=true)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(unique=true)
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
