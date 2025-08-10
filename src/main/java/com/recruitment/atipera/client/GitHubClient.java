package com.recruitment.atipera.client;

import com.recruitment.atipera.model.Branch;
import com.recruitment.atipera.model.Repository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GitHubClient {

    final RestTemplate restTemplate;

    final String gitHubUrl = "https://api.github.com";

    public GitHubClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Repository> getRepositoriesByUsername(String username) {
        String url = String.format("%s/users/%s/repos", gitHubUrl, username);

        return restTemplate.exchange(url, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Repository>>() {}).getBody();
    }
    public List<Branch> getBranchesByRepository(String username, String repositoryName) {
        String url = String.format("%s/repos/%s/%s/branches", gitHubUrl, username, repositoryName);

        return restTemplate.exchange(url, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Branch>>() {}).getBody();    }

}
