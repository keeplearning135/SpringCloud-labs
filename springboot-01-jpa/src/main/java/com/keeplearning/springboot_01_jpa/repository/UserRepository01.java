package com.keeplearning.springboot_01_jpa.repository;

import com.keeplearning.springboot_01_jpa.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<Users, Integer> {

}
