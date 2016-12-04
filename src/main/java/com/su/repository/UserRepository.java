package com.su.repository;

import com.su.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 06.11.2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
