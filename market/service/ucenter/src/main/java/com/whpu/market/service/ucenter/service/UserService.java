package com.whpu.market.service.ucenter.service;

import com.whpu.market.service.ucenter.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whpu.market.service.ucenter.entity.vo.UserLoginVo;


public interface UserService extends IService<User> {

    String login(UserLoginVo userLoginVo);
}
