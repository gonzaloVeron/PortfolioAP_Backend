package com.portfolio.PortfolioAP.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "skills")
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String name;

    @Column
    private int level;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Skill(){

    }

    public Skill(int id, String name, int level, User user) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.user = user;
    }

    public Skill(String name, int level, User user) {
        this.name = name;
        this.level = level;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
