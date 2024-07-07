package com.keeplearning.springboot04security.repository;

import com.keeplearning.springboot04security.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<Users, Integer> {

}
