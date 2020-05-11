package top.mitday.shiro_combat.config;

import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.mitday.shiro_combat.entity.Permission;
import top.mitday.shiro_combat.entity.Role;
import top.mitday.shiro_combat.entity.User;
import top.mitday.shiro_combat.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 进行权限校验的时候调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("用户授权 doGetAuthorizationInfo");

        User newuser = (User)principals.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(newuser.getUsername());

        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();

        List<Role> roleList = user.getRoleList();

        for (Role role : roleList){
            stringRoleList.add(role.getName());

            List<Permission> permissionList = role.getPermissionList();

            for (Permission permission : permissionList){
                if (permission != null){
                    stringPermissionList.add(permission.getName());
                }
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }

    /**
     * 用户登录的时候调用
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户登录 doGetAuthenticationInfo");

        /**
         * 从token中获取中户信息，token代表用户的输入
         */
        String username = String.valueOf(token.getPrincipal());
        User user = userService.findAllUserInfoByUsername(username);

        //获取密码
        String pwd = user.getPassword();
        if (pwd == null || "".equals(pwd)){ return null; }

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
