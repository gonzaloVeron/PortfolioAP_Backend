package com.portfolio.PortfolioAP.models;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "experiences")
@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String description;

    @Column
    private String title;

    @Column
    private String city;

    @Column
    private String company_name;

    @Column
    private LocalDate start_date;

    @Column
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public WorkExperience(){

    }

    public WorkExperience(int id, String description, String title, String city, String company_name, LocalDate start_date, LocalDate end_date, User user) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.city = city;
        this.company_name = company_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
