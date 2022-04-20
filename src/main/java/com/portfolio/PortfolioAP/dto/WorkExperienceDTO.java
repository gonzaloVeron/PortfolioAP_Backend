package com.portfolio.PortfolioAP.dto;

import com.portfolio.PortfolioAP.models.WorkExperience;

public class WorkExperienceDTO {

    private WorkExperience experience;

    private int user_id;

    public WorkExperienceDTO(WorkExperience experience, int user_id) {
        this.experience = experience;
        this.user_id = user_id;
    }

    public WorkExperience getExperience() {
        return experience;
    }

    public void setExperience(WorkExperience experience) {
        this.experience = experience;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
