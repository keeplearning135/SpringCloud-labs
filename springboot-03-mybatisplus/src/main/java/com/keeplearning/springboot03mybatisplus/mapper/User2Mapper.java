package com.keeplearning.springboot03mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keeplearning.springboot03mybatisplus.entity.User2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface User2Mapper extends BaseMapper<User2> {

    default User2 selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<User2>().eq("username", username));
    }

    default Collection<User2> selectByIds(@Param("ids") Collection<Integer> ids) {
        return selectBatchIds(ids);
    }

    default IPage<User2> selectPageByCreateTime(IPage<User2> page, @Param("createTime") Date createTime) {
        return selectPage(page,
                new QueryWrapper<User2>().gt("create_time", createTime)
//                new QueryWrapper<User2>().like("username", "46683d9d")
        );
    }

}
