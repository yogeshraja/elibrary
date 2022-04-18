package com.sirius.elibrary.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "authorityID_generator")
    private int aid;
    private String username;
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "uid",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Authority(String username, String authority, User user) {
        this.username = username;
        this.authority = authority;
        this.user = user;
    }

    public Authority() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
