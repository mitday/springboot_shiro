package top.mitday.shiro_combat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mitday.shiro_combat.utils.JsonData;

/**
 *logout,映射shiro自带的过滤器
 */
@RestController
public class LogoutController {

/*    @RequestMapping("/logout")
    public JsonData findMyLogout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipals() != null){

        }
        SecurityUtils.getSubject().logout();

        return JsonData.buildSuccess("logout成功");
    }*/
}
