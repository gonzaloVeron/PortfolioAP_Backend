package com.portfolio.PortfolioAP.models;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String about_me;

    @Column
    private String employment;

    @Column
    private String birth_date;

    @Column
    private String nationality;

    @Column
    private String profile_img;

    @Column
    private String background_img;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkExperience> experiences;

    public User(){

    }

    public User(int id, String name, String surname, String mail, String about_me, String employment, String birth_date, String nationality, String profile_img, String background_img) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = mail;
        this.about_me = about_me;
        this.employment = employment;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.profile_img = profile_img;
        this.background_img = background_img;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

}
