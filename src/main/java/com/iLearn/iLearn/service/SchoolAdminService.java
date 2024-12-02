package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.SchoolAdminRequest;
import com.iLearn.iLearn.dtos.response.SchoolAdminResponse;
import com.iLearn.iLearn.models.SchoolAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolAdminService {
    SchoolAdminResponse assignedClass(SchoolAdminRequest request);
}
