package com.keeplearning.springboot04security.repository;

import com.keeplearning.springboot04security.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<Users, Integer> {

}
