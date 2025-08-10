package com.recruitment.atipera.controller;

import com.recruitment.atipera.dto.RepositoryResponseDTO;
import com.recruitment.atipera.service.GitHubApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RepositoryController {
    private final GitHubApiService gitHubApiService;

    public RepositoryController(GitHubApiService gitHubApiService) {
        this.gitHubApiService = gitHubApiService;
    }
    @GetMapping("/{login}/repos")
    public ResponseEntity<List<RepositoryResponseDTO>> getUserRepositories(@PathVariable String login) {
        return ResponseEntity.ok(gitHubApiService.getUserRepositories(login));
    }
}
