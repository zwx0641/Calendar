package com.zeno.calendar.service;

import com.zeno.calendar.mapper.ReminderMapper;
import com.zeno.calendar.pojo.Reminder;
import com.zeno.calendar.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Calendar;
import java.util.Date;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean deleteReminder(String id) {
        Example reminderExample = new Example(Reminder.class);
        Example.Criteria criteria = reminderExample.createCriteria();
        criteria.andEqualTo("id", id);
        List<Reminder> reminderList = reminderMapper.selectByExample(reminderExample);
        for (Reminder reminder : reminderList) {
            reminderMapper.delete(reminder);
        }
        return true;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean updateTime(String id) {
        Example reminderExample = new Example(Reminder.class);
        Example.Criteria criteria = reminderExample.createCriteria();
        criteria.andEqualTo("id", id);
        List<Reminder> reminderList = reminderMapper.selectByExample(reminderExample);

        if (reminderList.isEmpty()) {
            return false;
        }

        // Judget repetition type and update the next remindTime according to the type
        for (Reminder reminder : reminderList) {
            Reminder updater = new Reminder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(reminder.getRemindTime());
            switch (reminder.getRepetition()) {
                case 1:
                    updater.setRemindTime(new Date(reminder.getRemindTime().getTime() + 24*60*60*1000));
                    reminderMapper.updateByExampleSelective(updater, reminderExample);
                    break;
                case 2:
                    updater.setRemindTime(new Date(reminder.getRemindTime().getTime() + 24*60*60*1000*7));
                    reminderMapper.updateByExampleSelective(updater, reminderExample);
                    break;
                case 3:
                    calendar.add(Calendar.MONTH, 1);
                    updater.setRemindTime(calendar.getTime());
                    reminderMapper.updateByExampleSelective(updater, reminderExample);
                    break;
                case 4:
                    calendar.add(Calendar.YEAR, 1);
                    updater.setRemindTime(calendar.getTime());
                    reminderMapper.updateByExampleSelective(updater, reminderExample);
                    break;
                default:
            }
        }

        return true;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Reminder> getDetailsOfReminder(String email, String remindText) {
        Example reminderExample = new Example(Reminder.class);
        Example.Criteria criteria = reminderExample.createCriteria();
        criteria.andEqualTo("email", email).andEqualTo("remindText", remindText);
        List<Reminder> reminderList = reminderMapper.selectByExample(reminderExample);
        return reminderList;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean editReminder(Reminder reminder) {
        Example example = new Example(Reminder.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", reminder.getId());

        if (reminderMapper.selectOneByExample(example) != null) {
            reminderMapper.updateByExampleSelective(reminder, example);
            return true;
        }

        return false;
    }
}
