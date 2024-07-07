package com.keeplearning.springboot01jpa.repository;

import com.keeplearning.springboot01jpa.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<Users, Integer> {

}
