package com.zeno.calendar.service;

import com.zeno.calendar.mapper.ReminderMapper;
import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author rf
 */
@Service
public class ReminderServiceImpl implements ReminderService {
    @Autowired
    private ReminderMapper reminderMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveReminder(Reminder reminder) {
        String reminderId = sid.nextShort();
        reminder.setId(reminderId);
        reminderMapper.insert(reminder);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Reminder> queryReminder(String email) {
        Example reminderExample = new Example(Reminder.class);
        Example.Criteria criteria = reminderExample.createCriteria();
        criteria.andEqualTo("email", email);
        return reminderMapper.selectByExample(reminderExample);
    }
}
