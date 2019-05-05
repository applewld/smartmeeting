package com.hznu.smartmeeting.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.dao.MeetingDao;
import com.hznu.smartmeeting.dao.MeetingPeopleDao;
import com.hznu.smartmeeting.entity.Meeting;
import com.hznu.smartmeeting.entity.MeetingPeople;
import com.hznu.smartmeeting.entity.Personal;
import com.hznu.smartmeeting.dao.PersonalDao;

import com.hznu.smartmeeting.service.MeetingPeopleService;
import com.hznu.smartmeeting.service.MeetingService;
import com.hznu.smartmeeting.service.PersonalService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@Service
public class PersonalServiceImpl extends ServiceImpl<PersonalDao, Personal> implements PersonalService {
    @Autowired
    MeetingPeopleService meetingPeopleService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MeetingPeopleDao meetingPeopleDao;

    @Autowired
    MeetingDao meetingDao;

    @Autowired
    PersonalService personalService;

    @Override
    public Personal loginByAccount(String accountNumber, String password){
        Personal personal = personalService.selectOne(new EntityWrapper<Personal>().eq("account_number",accountNumber));
        if(personal!=null&&personal.getPassword().equals(password)){
            return personal;
        }else{
            personal = null;
            return personal;
        }
    }

    @Override
    public List<Meeting> getMeetingList(int id){
        List<MeetingPeople> meetingPeopleList = meetingPeopleService.selectList(new EntityWrapper<MeetingPeople>().eq("personal_id",id));
        List<Meeting> meetingList = new ArrayList<>();

        for(int i=0;i<meetingPeopleList.size();i++){
            meetingList.add(meetingService.selectById(meetingPeopleList.get(i).getMeetingId()));
        }

        return meetingList;
    }

    public Meeting getCurrentMeeting(int id){
        List<MeetingPeople> meetingPeopleList = meetingPeopleDao.selectList(new EntityWrapper<MeetingPeople>().eq("personal_id",id));
        Meeting meeting=new Meeting();
        meeting = null;
        if(meetingPeopleList.size()>0){
            for(int i=0;i<meetingPeopleList.size();i++){
                int meetingId = meetingPeopleList.get(i).getMeetingId();
                Meeting temp = meetingDao.selectById(meetingId);
                if(temp.getState()==1){
                    meeting = temp;
                    break;
                }
            }
        }
        return meeting;
    }
}
