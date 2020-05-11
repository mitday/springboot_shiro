package top.mitday.shiro_combat.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 * 自定义session生成
 */
public class CustomSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        return "mitday"+UUID.randomUUID().toString().replace("-","");
    }
}
