package top.mitday.shiro_combat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mitday.shiro_combat.entity.Role;
import top.mitday.shiro_combat.entity.User;
import top.mitday.shiro_combat.mapper.RoleMapper;
import top.mitday.shiro_combat.mapper.UserMapper;
import top.mitday.shiro_combat.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {
        User user = userMapper.findByUsername(username);

        //用户的角色集合
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());

        user.setRoleList(roleList);

        return user;
    }

    @Override
    public User findSimpleUserInfoById(int userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User findSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
