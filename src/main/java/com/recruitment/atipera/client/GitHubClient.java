package com.recruitment.atipera.client;

import com.recruitment.atipera.model.Branch;
import com.recruitment.atipera.model.Repository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubClient {

    final RestTemplate restTemplate;

    final String gitHubUrl = "https://api.github.com";

    public GitHubClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Repository[] getRepositoriesByUsername(String username) {

        String RepositoryUrl = this.gitHubUrl + "/users/" + username + "/repos";

        return restTemplate.getForObject(RepositoryUrl, Repository[].class);
    }
    public Branch[] getBranchesByRepository(String username, String repositoryName) {

        String BranchUrl = this.gitHubUrl + "/repos/" + username + "/" + repositoryName + "/branches";

        return restTemplate.getForObject(BranchUrl, Branch[].class);
    }

}
