package top.mitday.shiro_basis.dao;

import org.springframework.stereotype.Repository;
import top.mitday.shiro_basis.entity.User;

@Repository
public class UserDao {

    public User findByid() {
        User user = new User();
        user.setName("小龙");
        user.setAge(12);
        user.setClassroom("三班");
        return user;
    }
}
