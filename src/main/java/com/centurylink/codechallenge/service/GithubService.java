package com.centurylink.codechallenge.service;

import com.centurylink.codechallenge.domain.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GithubService {
    private final RestTemplate restTemplate;

    @Value("${github.api.followers.endpoint}")
    private String GITHUB_FOLLOWERS_ENDPOINT;

    public GithubService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Profile> getGithubFollowers(String username, int levels) {
        List<Profile> profiles;
        int levelsDeep = levels - 1;

        String url = GITHUB_FOLLOWERS_ENDPOINT.replace(":username", username);
        profiles = this.restTemplate.exchange(url, HttpMethod.GET,
                getHttpEntity(""), new ParameterizedTypeReference<List<Profile>>() {
                }).getBody();

        if(levelsDeep > 0) {
            for (Profile profile : profiles) {
                profile.setFollowers(getGithubFollowers(profile.getLogin(), levelsDeep));
            }
        }
        return profiles;
    }

    private HttpEntity<?> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new HttpEntity<>(body, headers);
    }
}
