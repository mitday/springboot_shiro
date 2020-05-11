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
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Shiro内置jdbcRealm实操
 */
@SpringBootTest
public class shiroTest4 {

    @Test
    public void testAuthentication(){

        //创建SecurityManager工厂，通过配置文件ini创建
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbcrealm.ini");;

        SecurityManager securityManager = factory.getInstance();

        //将securityManager 设置到当前环境中
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        //用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack","123");

        //登录验证
        //会调用SecurityManager进行验证
        subject.login(usernamePasswordToken);

        //isAuthenticated()方法调用Authenticator执行认证，在根据Realm验证返回结果
        System.out.println("认证结果-："+subject.isAuthenticated());
        System.out.println("是否又对应得root角色： "+subject.hasRole("root"));
        System.out.println("获取角色名： "+subject.getPrincipal());
        subject.checkPermission("video:find");
        System.out.println( "是否有video:find 权限："+ subject.isPermitted("video:root"));

        subject.logout();

        System.out.println("logout后认证结果:"+subject.isAuthenticated());


    }

    @Test
    public void testAuthentication2(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mitday?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");


        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setDataSource(ds);

        securityManager.setRealm(jdbcRealm);

        //将securityManager 设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        //用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");

        subject.login(usernamePasswordToken);


        System.out.println(" 认证结果:"+subject.isAuthenticated());

        System.out.println(" 是否有对应的role1角色:"+subject.hasRole("role1"));

        System.out.println("是否有video:find权限:"+ subject.isPermitted("video:find"));

        System.out.println("是否有任意权限:"+ subject.isPermitted("aaaa:xxxxxxxxx"));

    }
}
