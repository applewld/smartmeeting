package com.hznu.smartmeeting.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.entity.Meeting;
import com.hznu.smartmeeting.entity.MeetingRoom;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 会议表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/meeting")
@Api(description = "会议管理接口",value = "meeting")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @ApiOperation("获取会议列表")
    @GetMapping("/getMeetingList")
    public R getMeetingList(){
        try
        {
            List<Meeting> meetingList=meetingService.selectList(new EntityWrapper<Meeting>());
            if(meetingList==null){
                return R.error(2,"无会议信息");
            }
            else{
                return R.ok().put("data",meetingList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除会议")
    @PostMapping("/deleteMeeting")
    public R deleteMeeting(@RequestBody Integer id){
        try
        {
            if(!meetingService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("更新会议")
    @PostMapping("/updateMeeting")
    public R updateMeeting(@RequestBody Meeting meeting){
        try
        {
            if(!meetingService.updateById(meeting)) {
                return R.error(2,"更新失败");
            }
            return R.ok("更新成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加会议")
    @PostMapping("/addMeeting")
    public R addMeeting(@RequestBody Meeting meeting){
        try
        {
            if(!meetingService.insert(meeting)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }
}

