package com.whpu.market.service.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.common.base.result.R;
import com.whpu.market.service.user.entity.User;
import com.whpu.market.service.user.entity.vo.UserQueryVo;
import com.whpu.market.service.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Api(description = "user")
@Api(tags = {"user"})
//@CrossOrigin //设置跨域
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @SentinelResource(
            value = "UserController.list",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("所有用户列表")
    @GetMapping("list")
    public R listAll(){
        List<User> list = userService.list();
        list.forEach(user -> {
            user.setPassWord("********");
        });
        return R.ok().data("items", list);
    }

    @SentinelResource(
            value = "UserController.save",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("新增用户")
    @PostMapping("save")
    public R save(
            @ApiParam("用户对象")
            @RequestBody User user
    ){
        boolean result = userService.checkAndSave(user);
        if (result){
            return R.ok().message("保存成功");
        }else {
            return R.error().message("非法数据");
        }
    }

    @SentinelResource(
            value = "UserController.remove",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation(value = "根据ID删除用户", notes = "根据ID删除用户，逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R deleteUserByID(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable String id
    ) {
        boolean result = userService.removeById(id);
        if(result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "UserController.update",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("更新用户")
    @PutMapping("update")
    public R updateById(
            @ApiParam("用户对象")
            @RequestBody User user
    ){
        boolean result = userService.updateById(user);
        if(result){
            return R.ok().message("修改成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "UserController.get",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("根据id获取用户信息")
    @GetMapping("get/{id}")
    public R getById(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable String id
    ){
        User user = userService.getById(id);
        if(user != null){
            user.setPassWord("******");
            return R.ok().data("item", user);
        }else{
            return R.error().message("数据不存在");
        }
    }


    @SentinelResource(
            value = "UserController.listPage",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("用户分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象") UserQueryVo userQueryVo){

        Page<User> pageParam = new Page<>(page, limit);
        IPage<User> pageModel = userService.selectPage(pageParam, userQueryVo);
        List<User> records = pageModel.getRecords();
        records.forEach(user -> {
            user.setPassWord("******");
        });
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

}

