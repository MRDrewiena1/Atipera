package com.recruitment.atipera.model;

import lombok.Builder;

import java.util.List;


@Builder
public record Repository(
        String name,
        Owner owner,
        List<Branch> branches
) {
}
