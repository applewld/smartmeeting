package com.hznu.smartmeeting.controller;


import com.hznu.smartmeeting.entity.Administrator;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.AdministratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-01-18
 */
@RestController
@RequestMapping("/administrator")
@Api(description = "管理员管理接口",value = "administrator")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @ApiOperation("添加管理员")
    @PostMapping("/addAdmin")
    public R add(@RequestBody Administrator administrator){
        try
        {
            administrator.setRegisterTime(new Date());
            if(!administratorService.insert(administrator)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("获取管理员信息")
    @GetMapping("/getAdminInfoByAdminId/{id}")
    public R getAdminInfo(@PathVariable  Integer id){
        try
        {
            Administrator administrator = administratorService.selectById(id);

            if(administrator!=null){
                R r = new R();
                r.put("data",administrator);
                return r;
            }
            else {
                return R.error(2,"该管理员信息不存在");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除管理员")
    @PostMapping("/deleteAdmin")
    public R deleteAdmin(@RequestBody Integer id){
        try
        {
            if(!administratorService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("更新管理员")
    @PostMapping("/updateAdmin")
    public R updateAdmin(@RequestBody Administrator administrator){
        try
        {
            if(!administratorService.updateById(administrator)) {
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

