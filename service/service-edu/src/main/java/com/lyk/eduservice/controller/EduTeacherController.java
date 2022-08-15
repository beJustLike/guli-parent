package com.lyk.eduservice.controller;


import com.lyk.eduservice.entity.EduTeacher;
import com.lyk.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lyk
 * @since 2022-08-12
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Resource
    private EduTeacherService eduTeacherService;

    //讲师列表
    @GetMapping("/findAll")
    @ApiOperation("讲师模块-讲师列表")
    public List<EduTeacher> findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    //逻辑删除讲师方法
    @ApiOperation("讲师模块-逻辑删除")
    @DeleteMapping("/removeById/{id}")
    public boolean removeById(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }




}

