package com.cmpt276_cs_prof_rate.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String imgLink;
    private String roleType;
    private String mail;
    private int clarity; 
    private int niceness;
    private int knowledgeableScore;

    public Users() {}
    
    public Users(String name, String imgLink, String roleType, String mail) {
        this.name = name;
        this.imgLink = imgLink;
        this.roleType = roleType;
        this.mail = mail;
        this.clarity = 0;
        this.niceness = 0;
        this.knowledgeableScore = 0;
    }

    public int getUid() {
        return uid;
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

    public void setUid(int uid) {
        this.uid = uid ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public void setNiceness(int niceness) {
        this.niceness = niceness;
    }

    public void setKnowledgeableScore(int knowledgeableScore) {
        this.knowledgeableScore = knowledgeableScore;
    }
}
