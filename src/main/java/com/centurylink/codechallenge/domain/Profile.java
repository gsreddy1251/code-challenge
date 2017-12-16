package com.centurylink.codechallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Profile {
    private String login;
    private Long id;
    private String type;
    @JsonProperty("site_admin")
    private Boolean siteAdmin;
    private List<Profile> followers;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }
}
