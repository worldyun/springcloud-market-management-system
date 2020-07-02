package com.whpu.market.service.ucenter.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.whpu.market.common.base.result.R;
import com.whpu.market.common.base.util.JwtInfo;
import com.whpu.market.common.base.util.JwtUtils;
import com.whpu.market.service.ucenter.entity.vo.UserLoginVo;
import com.whpu.market.service.ucenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@Api(tags = {"ucenter"})
@RestController
@RequestMapping("/api/ucenter")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @return
     */
    @SentinelResource(
            value = "LoginController.login",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("登录")
    @PostMapping("login")
    public R login(
            @ApiParam(value = "用户登录对象", required = true)
            @RequestBody UserLoginVo userLoginVo
            ){
        String token = userService.login(userLoginVo);
        if (token == null){
            return R.error().message("用户名或密码错误");
        }
        return R.ok().message("登录成功").data("token", token);
    }

    /**
     * 获取用户信息
     * @return
     */
    @SentinelResource(
            value = "LoginController.info",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public R info(HttpServletRequest request){
        try {
            JwtInfo info = JwtUtils.getMemberIdByJwtToken(request);
            return R.ok().data("name", info.getNickname())
                    .data("roles", info.getUserType())
                    .data("avatar", "http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg");
        }catch (Exception e){
            return R.error().code(23004).message("获取用户信息失败");
        }
    }

    /**
     * 退出
     * @return
     */
    @SentinelResource(
            value = "LoginController.lohout",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("登出")
    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }
}