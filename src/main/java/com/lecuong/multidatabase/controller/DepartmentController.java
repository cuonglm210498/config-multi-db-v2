package com.lecuong.multidatabase.controller;

import com.lecuong.multidatabase.entity.departmentservice.Department;
import com.lecuong.multidatabase.entity.userservice.User;
import com.lecuong.multidatabase.model.request.BaseRequest;
import com.lecuong.multidatabase.service.DepartmentService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author CuongLM
 * @created 16/07/2024 - 20:44
 * @project multi-database
 */
@Data
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.save(department));
    }

    @GetMapping
    public ResponseEntity<Page<Department>> findAll(@ModelAttribute BaseRequest baseRequest) {
        Pageable pageable = PageRequest.of(baseRequest.getPageIndex(), baseRequest.getPageSize());
        return ResponseEntity.ok(departmentService.findAll(pageable.previousOrFirst()));
    }
}
