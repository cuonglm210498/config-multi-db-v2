package com.lecuong.multidatabase.repository.departmentrepository;

import com.lecuong.multidatabase.entity.departmentservice.Department;
import com.lecuong.multidatabase.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CuongLM
 * @created 06/07/2024 - 01:01
 * @project multi-database
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department, Long> {
}
