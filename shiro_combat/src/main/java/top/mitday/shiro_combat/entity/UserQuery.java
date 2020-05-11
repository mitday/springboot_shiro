package top.mitday.shiro_combat.entity;

/**
 * 用于接收全段页面传来的账号密码信息
 */
public class UserQuery {

    private String name;

    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
