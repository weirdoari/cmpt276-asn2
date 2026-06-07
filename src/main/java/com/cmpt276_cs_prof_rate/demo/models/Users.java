package com.cmpt276_cs_prof_rate.demo.models;

public class Users {
    private String id;
    private String name;
    private String imgLink;
    private String roleType;
    private String mail;
    private int clarity; 
    private int niceness;
    private int knowledgeableScore;
    public Users() {}
    public Users(String id, String name, String imgLink, String roleType, String mail, int clarity, int niceness, int knowledgeableScore) {
        this.id = id;
        this.name = name;
        this.imgLink = imgLink;
        this.roleType = roleType;
        this.mail = mail;
        this.clarity = clarity;
        this.niceness = niceness;
        this.knowledgeableScore = knowledgeableScore;
    }
}
