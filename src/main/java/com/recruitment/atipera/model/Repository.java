package com.recruitment.atipera.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
        String name;
        Owner owner;
        List<Branch> branches;
        boolean fork;
}
