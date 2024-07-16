package com.lecuong.multidatabase.service.impl;

import com.lecuong.multidatabase.entity.userservice.User;
import com.lecuong.multidatabase.repository.userrepository.UserRepository;
import com.lecuong.multidatabase.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author CuongLM
 * @created 06/07/2024 - 00:33
 * @project multi-database
 */
@Data
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
