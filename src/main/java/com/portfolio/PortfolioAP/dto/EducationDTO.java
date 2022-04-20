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

    public float getAverage() {
        return average;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getInstitution() {
        return institution;
    }

    public int getStart_year() {
        return start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public int getUser_id() {
        return user_id;
    }

}
