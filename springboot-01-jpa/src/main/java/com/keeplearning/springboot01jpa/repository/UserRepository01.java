package com.keeplearning.springboot01jpa.repository;

import com.keeplearning.springboot01jpa.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<Users, Integer> {

}
