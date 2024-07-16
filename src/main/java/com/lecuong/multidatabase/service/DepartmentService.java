package com.lecuong.multidatabase.service;

import com.lecuong.multidatabase.entity.departmentservice.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author CuongLM
 * @created 16/07/2024 - 20:44
 * @project multi-database
 */
public interface DepartmentService {

    Department save(Department department);

    Page<Department> findAll(Pageable pageable);
}
