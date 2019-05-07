package com.hznu.smartmeeting.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hznu.smartmeeting.entity.*;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-05-06
 */
@RestController
@RequestMapping("/messageRecord")
@Api(description = "消息管理接口",value = "messageRecord")
public class MessageRecordController {
    @Autowired
    MessageRecordService messageRecordService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    MeetingPeopleService meetingPeopleService;

    @Autowired
    PersonalService personalService;

    @ApiOperation("获取消息列表(注：无筛选)")
    @GetMapping("/getMessageRecordList")
    public R getMessageRecordList(){
        try
        {
            List<MessageRecord> messageRecordList=messageRecordService.selectList(new EntityWrapper<MessageRecord>());
            if(messageRecordList==null){
                return R.error(2,"无会议室信息");
            }
            else{
                return R.ok().put("data",messageRecordList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("获取消息详情")
    @PostMapping("/getMessageRecordDetail")
    public R getMessageRecordDetail(@RequestBody Integer id){
        try
        {
            MessageRecord messageRecord=messageRecordService.selectById(id);
            if(messageRecord==null){
                return R.error(2,"无该信息记录");
            }
            else{
                Integer meetingId = messageRecord.getMeetingId();
                Meeting meeting  = meetingService.selectById(meetingId);
                HashMap data = new HashMap();
                data.put("meeting",meeting);
                MeetingRoom meetingRoom = meetingRoomService.selectById(meeting.getMeetingRoomId());
                data.put("room_number",meetingRoom.getRoomNumber());
                ArrayList<MeetingPeople> meetingPeopleList = (ArrayList<MeetingPeople>) meetingPeopleService.selectList(new EntityWrapper<MeetingPeople>().eq("meeting_id",meetingId));
                ArrayList<Personal> personalList = new ArrayList<>();
                for (int i=0;i<meetingPeopleList.size();i++){
                    personalList.add(personalService.selectById( meetingPeopleList.get(i).getPersonalId()));
                }
                data.put("personal",personalList);
                return R.ok().put("data",data);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("获取到会情况")
    @PostMapping("/getMeetingCondition")
    public R getMeetingCondition(@RequestBody Integer id){
        try
        {
            MessageRecord messageRecord=messageRecordService.selectById(id);
            if(messageRecord==null){
                return R.error(2,"无该信息记录");
            }
            else{
                Integer meetingId = messageRecord.getMeetingId();
                HashMap data = new HashMap();
                ArrayList<MeetingPeople> meetingPeopleList = (ArrayList<MeetingPeople>) meetingPeopleService.selectList(new EntityWrapper<MeetingPeople>().eq("meeting_id",meetingId));

                ArrayList<HashMap<String,Object>> personalList = new ArrayList<>();
                for (int i=0;i<meetingPeopleList.size();i++){
                    HashMap<String,Object> personal = new HashMap<>();
                    personal.put("personalInfo",personalService.selectById( meetingPeopleList.get(i).getPersonalId()));
                    personal.put("meetingCondition",meetingPeopleList.get(i));
                    personalList.add(personal);
                }
//                data.put("personal",personalList);
                return R.ok().put("data",personalList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加消息")
    @PostMapping("/addMessageRecord")
    public R addMessageRecord(@RequestBody MessageRecord messageRecord){
        try
        {
            if(!messageRecordService.insert(messageRecord)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除会议室")
    @PostMapping("/deleteMessageRecord")
    public R deleteMessageRecord(@RequestBody Integer id){
        try
        {
            if(!messageRecordService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("更新会议室")
    @PostMapping("/updateMessageRecord")
    public R updateMessageRecord(@RequestBody MessageRecord messageRecord){
        try
        {
            if(!messageRecordService.updateById(messageRecord)) {
                return R.error(2,"更新失败");
            }
            return R.ok("更新成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }
}

