package com.keeplearning.springboot01jpa.repository;

import com.keeplearning.springboot01jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<User, Integer> {

}
