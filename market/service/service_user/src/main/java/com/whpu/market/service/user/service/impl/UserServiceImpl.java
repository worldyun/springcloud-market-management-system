package com.whpu.market.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.user.entity.User;
import com.whpu.market.service.user.entity.vo.UserQueryVo;
import com.whpu.market.service.user.mapper.UserMapper;
import com.whpu.market.service.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> selectPage(Page<User> pageParam, UserQueryVo userQueryVo) {

        //根据id倒叙
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("user_type").orderByDesc("id");

        if (userQueryVo == null) {
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        //模糊查询
        String userName = userQueryVo.getNickName();
        if(!StringUtils.isEmpty(userName)){
            queryWrapper.likeRight("nick_name", userName);
        }

        return baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public boolean checkAndSave(User user) {
        if (StringUtils.isEmpty(user.getUserName())
                ||StringUtils.isEmpty(user.getPassWord())
                ||StringUtils.isEmpty(user.getBirth())
                ||StringUtils.isEmpty(user.getSex())
                ||StringUtils.isEmpty(user.getUserType())
        ){
            return false;
        }
        if (user.getNickName() == null){
            user.setNickName(user.getUserName());
        }
        return this.save(user);
    }
}
