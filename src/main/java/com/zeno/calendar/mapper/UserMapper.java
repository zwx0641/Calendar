package com.zeno.calendar.mapper;

import com.zeno.calendar.pojo.User;
import com.zeno.calendar.pojo.UserExample;
import com.zeno.calendar.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}