package com.portfolio.PortfolioAP.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;

    public User(){

    }

    public User(int id, String name, String surname, String password, String email, String about_me, String employment, String birth_date, String nationality, String profile_img, String background_img, List<Education> educations, List<WorkExperience> experiences, List<Project> projects, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.about_me = about_me;
        this.employment = employment;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.profile_img = profile_img;
        this.background_img = background_img;
        this.educations = educations;
        this.experiences = experiences;
        this.projects = projects;
        this.skills = skills;
    }

    public User(String name, String surname, String mail, String about_me, String employment, String birth_date, String nationality, String profile_img, String background_img){
        this.name = name;
        this.surname = surname;
        this.email = mail;
        this.about_me = about_me;
        this.employment = employment;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.profile_img = profile_img;
        this.background_img = background_img;
        this.educations = new ArrayList<Education>();
        this.experiences = new ArrayList<WorkExperience>();
        this.projects = new ArrayList<Project>();
        this.skills = new ArrayList<Skill>();
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

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<WorkExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<WorkExperience> experiences) {
        this.experiences = experiences;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
