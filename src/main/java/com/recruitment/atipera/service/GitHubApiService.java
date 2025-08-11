package com.recruitment.atipera.service;

import com.recruitment.atipera.client.GitHubClient;
import com.recruitment.atipera.dto.RepositoryResponseDTO;
import com.recruitment.atipera.exception.UserNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class GitHubApiService {
    private final GitHubClient gitHubClient;
    GitHubApiService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }
    public List<RepositoryResponseDTO> getUserRepositories(String login) {
        try {
        List<RepositoryResponseDTO> repositoryResponseDTOList = gitHubClient.getRepositoriesByUsername(login)
                .stream()
                .filter(repository -> !repository.isFork())
                .peek(repository -> repository.setBranches(
                        gitHubClient.getBranchesByRepository(login, repository.getName()
                        )))
                .map(RepositoryResponseDTO::new)
                .toList();
            return repositoryResponseDTOList;
        }catch (HttpClientErrorException e) {
            throw new UserNotFoundException("User not found");
        }

        }

}
