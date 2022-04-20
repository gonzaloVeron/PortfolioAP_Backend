package com.portfolio.PortfolioAP.models;

import javax.persistence.*;

@Table(name = "educations")
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String career;

    @Column
    private float average;

    @Column
    private String image;

    @Column
    private String title;

    @Column
    private String institution;

    @Column
    private int start_year;

    @Column
    private int end_year;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Education(){

    }

    public Education(int id, String career, float average, String image, String title, String institution, int start_year, int end_year, User user) {
        this.id = id;
        this.career = career;
        this.average = average;
        this.image = image;
        this.title = title;
        this.institution = institution;
        this.start_year = start_year;
        this.end_year = end_year;
        this.user = user;
    }

    public Education(String career, float average, String image, String title, String institution, int start_year, int end_year, User user) {
        this.career = career;
        this.average = average;
        this.image = image;
        this.title = title;
        this.institution = institution;
        this.start_year = start_year;
        this.end_year = end_year;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
