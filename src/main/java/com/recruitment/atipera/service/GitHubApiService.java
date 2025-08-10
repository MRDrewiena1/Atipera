package com.recruitment.atipera.service;

import com.recruitment.atipera.client.GitHubClient;
import com.recruitment.atipera.dto.RepositoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubApiService {
    private final GitHubClient gitHubClient;
    GitHubApiService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }
    public List<RepositoryResponseDTO> getUserRepositories(String login) {
        List<RepositoryResponseDTO> repositoryResponseDTOList = gitHubClient.getRepositoriesByUsername(login)
                .stream()
                .filter(repository -> !repository.isFork())
                .peek(repository -> repository.setBranches(
                        gitHubClient.getBranchesByRepository(login, repository.getName()
                        )))
                .map(RepositoryResponseDTO::new)
                .toList();
        if (repositoryResponseDTOList.isEmpty()) {
            //todo
        }
        return repositoryResponseDTOList;
    }

}
