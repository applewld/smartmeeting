package com.hznu.smartmeeting.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hznu.smartmeeting.entity.Dictionaries;
import com.hznu.smartmeeting.mybeans.R;
import com.hznu.smartmeeting.service.DictionariesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/dictionaries")
@Api(description = "字典管理接口",value = "dictionaries")
public class DictionariesController {
    @Autowired
    DictionariesService dictionariesService;

    @ApiOperation("获取字典列表")
    @GetMapping("/getDictionariesList")
    public R getDictionariesList(){
        try
        {
            List<Dictionaries> dictionaries = dictionariesService.selectList(new EntityWrapper<Dictionaries>());

            if(dictionaries!=null){
                R r = new R();
                r.put("data",dictionaries);
                return r;
            }
            else {
                return R.error(2,"字典不存在");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("添加字典")
    @PostMapping("/addDictionaries")
    public R addDictionaries(@RequestBody Dictionaries dictionaries){
        try
        {
            if(!dictionariesService.insert(dictionaries)) {
                return R.error(2,"添加失败");
            }
            return R.ok("添加成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("删除字典")
    @PostMapping("/deleteDictionaries")
    public R deleteDictionaries(@RequestBody Integer id){
        try
        {
            if(!dictionariesService.deleteById(id)) {
                return R.error(2,"删除失败");
            }
            return R.ok("删除成功");
        } catch (Exception e)
        {
            e.printStackTrace();
            return R.error();
        }
    }

    @ApiOperation("更新字典")
    @PostMapping("/updateDictionaries")
    public R updateDictionaries(@RequestBody Dictionaries dictionaries){
        try
        {
            if(!dictionariesService.updateById(dictionaries)) {
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

