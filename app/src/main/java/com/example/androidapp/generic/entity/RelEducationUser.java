package com.example.androidapp.generic.entity;


public class RelEducationUser {
    private Long id;

    private Education education;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RelEducationUser{" +
                "id=" + id +
                ", education=" + education +
                ", user=" + user +
                '}';
    }
}
