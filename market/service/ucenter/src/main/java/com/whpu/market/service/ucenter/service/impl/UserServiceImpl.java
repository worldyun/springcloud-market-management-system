package com.whpu.market.service.ucenter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whpu.market.common.base.util.JwtInfo;
import com.whpu.market.common.base.util.JwtUtils;
import com.whpu.market.service.ucenter.entity.User;
import com.whpu.market.service.ucenter.entity.vo.UserLoginVo;
import com.whpu.market.service.ucenter.mapper.UserMapper;
import com.whpu.market.service.ucenter.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public String login(UserLoginVo userLoginVo) {
        String userName = userLoginVo.getUsername();
        String passWord = userLoginVo.getPassword();

        if (StringUtils.isEmpty(userName)
                || StringUtils.isEmpty(passWord)
        ){
            return null;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        User user = baseMapper.selectOne(queryWrapper);

        if (user == null){
            return null;
        }

        if (!passWord.equals(user.getPassWord())){
            return null;
        }

        JwtInfo info = new JwtInfo();
        info.setId(user.getId());
        info.setNickname(user.getNickName());
        info.setUserType(user.getUserType());

        return JwtUtils.getJwtToken(info, 1200);

    }
}
