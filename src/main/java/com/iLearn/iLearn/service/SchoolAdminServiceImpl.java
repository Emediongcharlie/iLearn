package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.SchoolAdminRequest;
import com.iLearn.iLearn.dtos.response.SchoolAdminResponse;
import com.iLearn.iLearn.models.ClassLevel;
import com.iLearn.iLearn.models.SchoolAdmin;
import com.iLearn.iLearn.repositories.SchoolAdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolAdminServiceImpl implements SchoolAdminService {

    @Autowired
    private SchoolAdminRepository adminRepository;

    @Override
    public SchoolAdminResponse assignedClass(SchoolAdminRequest request) {
        SchoolAdmin schoolAdmin = new SchoolAdmin();
        schoolAdmin.setFirstname(request.getFirstname());
        schoolAdmin.setLastname(request.getLastname());
        schoolAdmin.setSetClassLevelArm(request.getSetClassLevelArm());
        adminRepository.save(schoolAdmin);
        SchoolAdminResponse response = new SchoolAdminResponse();
        response.setFirstname(schoolAdmin.getFirstname());
        response.setLastname(schoolAdmin.getLastname());
        response.setSetClassLevelArm(String.valueOf(ClassLevel.PRIMARYTWO));
        return response;

    }
}
