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
 * spring boot 整合Shiro认证和授权实操 上
 */
@SpringBootTest
public class shiroTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    //构建SecurityManager环境
    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init(){
        //初始化数据源
        simpleAccountRealm.addAccount("mitday","123");
        simpleAccountRealm.addAccount("jack","456");

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
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("mitday","123");

        //登录验证
        //会调用SecurityManager进行验证
        subject.login(usernamePasswordToken);

        //isAuthenticated()方法调用Authenticator执行认证，在根据Realm验证返回结果
        System.out.println("认证结果-："+subject.isAuthenticated());
    }
}
