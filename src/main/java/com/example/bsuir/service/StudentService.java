package com.example.bsuir.service;

import com.example.bsuir.model.StudentGroup;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Service
public class StudentService {

    private static final String GROUPS_API_URL = "https://iis.bsuir.by/api/v1/student-groups";

    public List<StudentGroup> getStudentGroups() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<StudentGroup>> response = restTemplate.exchange(
                GROUPS_API_URL,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StudentGroup>>() {}
        );

        return response.getBody();
    }
}
