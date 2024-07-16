package com.lecuong.multidatabase.controller;

import com.lecuong.multidatabase.entity.userservice.User;
import com.lecuong.multidatabase.model.request.BaseRequest;
import com.lecuong.multidatabase.service.UserService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author CuongLM
 * @created 06/07/2024 - 00:35
 * @project multi-database
 */
@Data
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<Page<User>> findAll(@ModelAttribute BaseRequest baseRequest) {
        Pageable pageable = PageRequest.of(baseRequest.getPageIndex(), baseRequest.getPageSize());
        return ResponseEntity.ok(userService.findAll(pageable.previousOrFirst()));
    }
}
