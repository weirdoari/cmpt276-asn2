package com.cmpt276_cs_prof_rate.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int  userId;
    private String text;

    public Comment() {}

    public Comment(int id, int userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }
}