package com.portfolio.PortfolioAP.dto;

import com.portfolio.PortfolioAP.models.User;

public class UserLoggedDTO {

    private User user;

    private String token;

    public UserLoggedDTO(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
