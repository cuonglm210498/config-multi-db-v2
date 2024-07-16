package com.lecuong.multidatabase.service;

import com.lecuong.multidatabase.entity.userservice.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author CuongLM
 * @created 06/07/2024 - 00:32
 * @project multi-database
 */
public interface UserService {

    User save(User user);

    Page<User> findAll(Pageable pageable);
}
