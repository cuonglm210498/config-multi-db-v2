package com.lecuong.multidatabase.repository.userrepository;

import com.lecuong.multidatabase.entity.userservice.User;
import com.lecuong.multidatabase.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CuongLM
 * @created 06/07/2024 - 00:31
 * @project multi-database
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
