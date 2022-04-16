package com.portfolio.PortfolioAP.dto;

import com.portfolio.PortfolioAP.models.Education;

public class EducationDTO {

    private Education education;

    private int user_id;

    public EducationDTO(Education education, int user_id) {
        this.education = education;
        this.user_id = user_id;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
}
