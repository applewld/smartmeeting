package com.hznu.smartmeeting.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.entity.MeetingRoom;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.MeetingRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会议室表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/meetingRoom")
@Api(description = "会议室管理接口",value = "meetingRoom")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @ApiOperation("获取会议室列表")
    @GetMapping("/getMeetingRoomList")
    public R getAllMeetingRoomInfo(){
        try
        {
            List<MeetingRoom> meetingRoomList=meetingRoomService.selectList(new EntityWrapper<MeetingRoom>());
            if(meetingRoomList==null){
                return R.error(2,"无会议室信息");
            }
            else{
                return R.ok().put("data",meetingRoomList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("获取会议室列表根据条件")
    @PostMapping("/getMeetingRoomByCondition")
    public R getMeetingRoomByCondition(@RequestBody MeetingRoom meetingRoom){
        try
        {
            List<MeetingRoom> meetingRoomList=meetingRoomService.selectList(new EntityWrapper<MeetingRoom>());
            ArrayList<MeetingRoom> meetingRoomData = new ArrayList<>();

            for(int i=0;i<meetingRoomList.size();i++){
                    if(meetingRoomList.get(i).getCapacity()>=meetingRoom.getCapacity()){
                        meetingRoomData.add(meetingRoomList.get(i));
                    }
            }

            if(meetingRoomData.size()==0){
                return R.error(2,"无满足条件会议室");
            }
            else{
                return R.ok().put("data",meetingRoomData);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加会议室")
    @PostMapping("/addMeetingRoom")
    public R addMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        try
        {
            if(!meetingRoomService.insert(meetingRoom)) {
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
    @PostMapping("/deleteMeetingRoom")
    public R deleteMeetingRoom(@RequestBody Integer id){
        try
        {
            if(!meetingRoomService.deleteById(id)) {
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
    @PostMapping("/updateMeetingRoom")
    public R updateMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        try
        {
            if(!meetingRoomService.updateById(meetingRoom)) {
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

