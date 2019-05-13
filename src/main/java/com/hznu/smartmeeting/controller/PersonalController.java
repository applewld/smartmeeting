package com.hznu.smartmeeting.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.entity.Meeting;
import com.hznu.smartmeeting.entity.Personal;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.PersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/personal")
@Api(description = "人员管理接口",value = "personal")
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @ApiOperation("获取人员列表")
    @GetMapping("/getPersonalList")
    public R getPersonalList(){
        try
        {
            List<Personal> personalList=personalService.selectList(new EntityWrapper<Personal>());
            if(personalList==null){
                return R.error(2,"无人员信息");
            }
            else{
                return R.ok().put("data",personalList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("预约端账户登录")
    @PostMapping("/loginByAccount")
    public R loginByAccount(@RequestBody JSONObject jsonObject){
        try{
            Personal personal=personalService.loginByAccount(jsonObject.get("accountNumber").toString(),jsonObject.get("password").toString());
            if(personal==null){
                return R.error(2,"账号或密码错误");
            }else{
                R r = R.ok("登录成功");
                r.put("data",personal);
                return r;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("获取参与的所有会议列表")
    @GetMapping("/getMeetingListByPersonalId/{id}")
    public R getMeetingList(@PathVariable(value = "id") Integer personalId){
        try
        {
            List<Meeting> meetingList = personalService.getMeetingList(personalId);
            if(meetingList.size()>0){
                return R.ok().put("data",meetingList);
            }
            else{
                return R.error(2,"该与会人员无会议记录");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("与会人员获取当前会议信息")
    @GetMapping("/getCurrentMeetingByPersonalId/{id}")
    public R getCurrentMeeting(@PathVariable(value = "id") Integer personalId){
        try
        {
            if((personalService.getCurrentMeeting(personalId))==null){
               return R.error(2,"此人当前无会议");
            }
            else{
                return R.ok().put("data",personalService.getCurrentMeeting(personalId));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加人员")
    @PostMapping("/addPersonal")
    public R addMeetingRoom(@RequestBody Personal personal){
        try
        {
            if(!personalService.insert(personal)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除人员")
    @PostMapping("/deletePersonal")
    public R deletePersonal(@RequestBody Integer id){
        try
        {
            if(!personalService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("更新人员")
    @PostMapping("/updatePersonal")
    public R updateDictionaries(@RequestBody Personal personal){
        try
        {
            if(!personalService.updateById(personal)) {
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

