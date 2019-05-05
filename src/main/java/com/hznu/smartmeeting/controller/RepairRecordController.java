package com.hznu.smartmeeting.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.entity.RepairRecord;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.RepairRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 报修记录表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/repairRecord")
@Api(description = "报修记录管理接口",value = "repairRecord")
public class RepairRecordController {
    @Autowired
    RepairRecordService repairRecordService;

    @ApiOperation("获取报修记录列表")
    @GetMapping("/getRepairRecordList")
    public R getRepairRecordList(){
        try
        {
            List<RepairRecord> repairRecordList=repairRecordService.selectList(new EntityWrapper<RepairRecord>());
            if(repairRecordList==null){
                return R.error(2,"无会议室信息");
            }
            else{
                return R.ok().put("data",repairRecordList);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加报修记录")
    @PostMapping("/addRepairRecord")
    public R addMeetingRoom(@RequestBody RepairRecord repairRecord){
        try
        {
            if(!repairRecordService.insert(repairRecord)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除报修记录")
    @PostMapping("/deleteRepairRecord")
    public R deleteRepairRecord(@RequestBody Integer id){
        try
        {
            if(!repairRecordService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }
}

