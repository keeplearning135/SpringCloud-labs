package com.keeplearning.springboot01jpa.repository;

import com.keeplearning.springboot01jpa.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<User, Integer> {

}
