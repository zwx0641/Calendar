package com.zeno.calendar.mapper;

import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.pojo.ReminderExample;
import com.zeno.calendar.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReminderMapper extends MyMapper<Reminder> {
    long countByExample(ReminderExample example);

    int deleteByExample(ReminderExample example);

    List<Reminder> selectByExample(ReminderExample example);

    int updateByExampleSelective(@Param("record") Reminder record, @Param("example") ReminderExample example);

    int updateByExample(@Param("record") Reminder record, @Param("example") ReminderExample example);
}