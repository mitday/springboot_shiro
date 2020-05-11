package top.mitday.shiro_basis.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mitday.shiro_basis.entity.User;
import top.mitday.shiro_basis.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByid")
    @ResponseBody
    @RequiresRoles(value = {"admin","user"},logical = Logical.AND)
    public User userController(){
        return userService.saveWeChatUser();
    }

}
