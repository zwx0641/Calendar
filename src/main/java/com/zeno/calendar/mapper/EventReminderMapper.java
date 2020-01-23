package com.zeno.calendar.mapper;

import com.zeno.calendar.pojo.EventReminder;
import com.zeno.calendar.pojo.EventReminderExample;
import com.zeno.calendar.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventReminderMapper extends MyMapper<EventReminder> {
    long countByExample(EventReminderExample example);

    int deleteByExample(EventReminderExample example);

    List<EventReminder> selectByExample(EventReminderExample example);

    int updateByExampleSelective(@Param("record") EventReminder record, @Param("example") EventReminderExample example);

    int updateByExample(@Param("record") EventReminder record, @Param("example") EventReminderExample example);
}