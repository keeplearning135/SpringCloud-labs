package com.keeplearning.springboot05redis.mapper;

import com.keeplearning.springboot05redis.dataobject.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper extends BaseMapper<UserDO> {

    @CachePut(key = "#id")
    default UserDO selectById0(Integer id) {
        UserDO user = this.selectById(id);
        // 返回用户
        return user;
    }

    @CachePut(key = "#user.id")
    default UserDO insert0(UserDO user) {
        // 插入记录
        this.insert(user);
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);

}
