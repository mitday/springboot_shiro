package top.mitday.shiro_basis;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * spring boot 整合Shiro认证和授权实操 下 常用API
 */
@SpringBootTest
public class shiroTest2 {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    //构建SecurityManager环境
    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init(){
        //初始化数据源
        simpleAccountRealm.addAccount("mitday","123","root");
        simpleAccountRealm.addAccount("jack","456","user");

        //构建环境
        defaultSecurityManager.setRealm(simpleAccountRealm);
    }

    @Test
    public void testAuthentication(){

        //生成上下文, 把SecurityManager设置进去
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //执行授权
        Subject subject = SecurityUtils.getSubject();

        //用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack","456");

        //登录验证
        //会调用SecurityManager进行验证
        subject.login(usernamePasswordToken);

        subject.hasRole("root");

        //isAuthenticated()方法调用Authenticator执行认证，在根据Realm验证返回结果
        System.out.println("认证结果-："+subject.isAuthenticated());
        System.out.println("是否又对应得root角色： "+subject.hasRole("root"));
        System.out.println("获取角色名： "+subject.getPrincipal());
        System.out.println("是否是admin普通管理员角色： "+subject.hasRole("admin"));

        //退出登录
        subject.logout();

        System.out.println("认证结果-："+subject.isAuthenticated());
    }
}
