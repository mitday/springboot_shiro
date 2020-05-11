package top.mitday.shiro_basis.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mitday.shiro_basis.dao.UserDao;
import top.mitday.shiro_basis.entity.User;
import top.mitday.shiro_basis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveWeChatUser() {
        return userDao.findByid();
    }
}
