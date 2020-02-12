package com.zeno.calendar.mapper;

import com.zeno.calendar.pojo.Event;
import com.zeno.calendar.pojo.EventExample;
import com.zeno.calendar.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventMapper extends MyMapper<Event> {
    long countByExample(EventExample example);

    int deleteByExample(EventExample example);

    List<Event> selectByExample(EventExample example);

    int updateByExampleSelective(@Param("record") Event record, @Param("example") EventExample example);

    int updateByExample(@Param("record") Event record, @Param("example") EventExample example);
}