package com.recruitment.atipera.dto;

import com.recruitment.atipera.model.Branch;
import com.recruitment.atipera.model.Owner;
import com.recruitment.atipera.model.Repository;

import java.util.List;

public record RepositoryResponseDTO(
        String name,
        Owner owner,
        List<Branch> branches
) {
    public RepositoryResponseDTO(Repository repository) {
        this(
                repository.getName(),
                repository.getOwner(),
                repository.getBranches()
        );
    }

}
