package top.mitday.shiro_combat;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;

public class Md5Test {

    @Test
    public void testMD5(){
        //加密所使用的算法
        String hashName = "md5";

        //加密明文  即用户密码
        String pwd = "123";

        //加密函数，使用shiro自带的
        Object result = new SimpleHash(hashName,pwd,null,2);

        System.out.println(result);
    }
}
