package top.mitday.shiro_basis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Shiro自定义Realm实操  常用
 */
@SpringBootTest
public class shiroTest5 {

    private CustomRealm customRealm = new CustomRealm();

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

    @Before
    public void init(){

        //构建环境
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
    }

    @Test
    public void testAuthentication(){

        //获取当前操作的主体
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("mitday","456");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果：==" +subject.isAuthenticated());

        //拿到主体标识属性
        System.out.println("获取角色名： "+subject.getPrincipal());

        System.out.println("是否有对应的角色:"+subject.hasRole("role1"));

        System.out.println("是否有对应的权限:"+subject.isPermitted("video:add"));

    }

}
