package com.centurylink.codechallenge.controller;

import com.centurylink.codechallenge.domain.Profile;
import com.centurylink.codechallenge.service.GithubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("github/followers/{username}")
    public ResponseEntity<List<Profile>> getGithubFollowers(@PathVariable String username) {
        List<Profile> profiles = githubService.getGithubFollowers(username, 3);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
