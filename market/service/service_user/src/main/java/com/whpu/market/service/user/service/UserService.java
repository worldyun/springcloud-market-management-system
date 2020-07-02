package com.whpu.market.service.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whpu.market.service.user.entity.vo.UserQueryVo;


public interface UserService extends IService<User> {

    IPage<User> selectPage(Page<User> pageParam, UserQueryVo userQueryVo);
    boolean checkAndSave(User user);
}
