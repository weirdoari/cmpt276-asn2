package com.cmpt276_cs_prof_rate.demo.models;

import java.util.ArrayList;

public class Users {
    private String id;
    private String name;
    private String imgLink;
    private String roleType;
    private String mail;
    private int clarity; 
    private int niceness;
    private int knowledgeableScore;
    private ArrayList<String> comments;

    public Users() {}
    
    public Users(String id, String name, String imgLink, String roleType, String mail) {
        this.id = id;
        this.name = name;
        this.imgLink = imgLink;
        this.roleType = roleType;
        this.mail = mail;
        this.clarity = 0;
        this.niceness = 0;
        this.knowledgeableScore = 0;
        this.comments = new ArrayList<>();
        this.comments.add("No comments yet.");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getRoleType() {
        return roleType;
    }

    public String getMail() {
        return mail;
    }

    public int getClarity() {
        return clarity;
    }

    public int getNiceness() {
        return niceness;
    }

    public int getKnowledgeableScore() {
        return knowledgeableScore;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
}
