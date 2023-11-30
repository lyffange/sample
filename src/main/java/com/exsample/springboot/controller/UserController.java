package com.exsample.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exsample.springboot.common.ServiceResultConstant;
import com.exsample.springboot.domain.dto.ServiceResult;
import com.exsample.springboot.domain.po.User;
import com.exsample.springboot.service.UserService;
import com.exsample.springboot.utils.ServiceResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;

@Slf4j
@Path("/demo")
@Component
public class UserController {
    @Autowired
    UserService userService;
    @GET
    @Path("/select")
    @Produces("application/json;charset=utf-8")
    public ServiceResult getList(@QueryParam("pageNum") @DefaultValue("1") Integer pageNum,
                                 @QueryParam("pageSize") @DefaultValue("10") Integer pageSize,
                                 @QueryParam("name")  String name){
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<User> condition = new QueryWrapper<>();
        if(name != null &&!name.trim().equals("")){
            condition.eq("name", name);
        }
        List<User> list = userService.list(condition);
            return new ServiceResult()
                    .setCode(ServiceResultConstant.SUCCESS_CODE)
                    .setMsg(ServiceResultConstant.QUERY_SUCCESS)
                    .setData(list)
                    .setPageNum(pageNum)
                    .setPageSize(pageSize)
                    .setTotal(page.getTotal());
    }

    @POST
    @Path("/add")
    @Consumes("*/*")
    @Produces("application/json;charset=utf-8")
    public ServiceResult add(@RequestBody User user){
        Integer age = user.getAge();
        Long id = user.getId();
        String name = user.getName();
//        String sex = user.getSex();
        if(age == null||id == null|| name == null){
            return ServiceResultUtil.getServiceResult(ServiceResultConstant.FAILED_CODE, ServiceResultConstant.ADD_FAILE_MSG + "请检查参数都不为null",false);
        }
        boolean result = userService.save(user);
        return ServiceResultUtil.getServiceResult(ServiceResultConstant.SUCCESS_CODE, ServiceResultConstant.QUERY_SUCCESS,result);
    }
}
