package com.portfolio.PortfolioAP.dto;

public class UserDTO {

    private String name;

    private String surname;

    private String password;

    private String email;

    private String about_me;

    private String employment;

    private String birth_date;

    private String nationality;

    private String profile_img;

    private String background_img;

    public UserDTO(String name, String surname, String password, String email, String about_me, String employment, String birth_date, String nationality, String profile_img, String background_img) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
