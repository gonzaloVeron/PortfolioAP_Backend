package com.portfolio.PortfolioAP.dto;

public class EducationDTO {

    private String career;

    private float average;

    private String image;

    private String title;

    private String institution;

    private int start_year;

    private int end_year;

    private int user_id;

    public EducationDTO(String career, float average, String image, String title, String institution, int start_year, int end_year, int user_id) {
        this.career = career;
        this.average = average;
        this.image = image;
        this.title = title;
        this.institution = institution;
        this.start_year = start_year;
        this.end_year = end_year;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
