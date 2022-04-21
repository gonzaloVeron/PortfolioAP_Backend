package com.portfolio.PortfolioAP.dto;

import com.portfolio.PortfolioAP.models.WorkExperience;

import java.time.LocalDate;

public class WorkExperienceDTO {

    private String description;

    private String title;

    private String city;

    private String company_name;

    private LocalDate start_date;

    private LocalDate end_date;

    public WorkExperienceDTO(){

    }

    public WorkExperienceDTO(String description, String title, String city, String company_name, LocalDate start_date, LocalDate end_date) {
        this.description = description;
        this.title = title;
        this.city = city;
        this.company_name = company_name;
        this.start_date = start_date;
        this.end_date = end_date;
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
}
