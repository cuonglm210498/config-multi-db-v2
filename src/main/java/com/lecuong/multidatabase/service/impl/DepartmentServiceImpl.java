package com.lecuong.multidatabase.service.impl;

import com.lecuong.multidatabase.entity.departmentservice.Department;
import com.lecuong.multidatabase.repository.departmentrepository.DepartmentRepository;
import com.lecuong.multidatabase.service.DepartmentService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author CuongLM
 * @created 16/07/2024 - 20:44
 * @project multi-database
 */
@Data
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable.previousOrFirst());
    }
}
