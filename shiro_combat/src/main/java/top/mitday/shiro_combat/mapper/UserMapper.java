package top.mitday.shiro_combat.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.mitday.shiro_combat.entity.User;

@Repository
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username")String username);

    @Select("select * from user where id = #{userId}")
    User findById(@Param("userId")int userId);

    @Select("select * from user where username = #{username} and password = #{pwd}")
    User findByUsernameAndPwd(@Param("username")String username,@Param("pwd")String pwd);
}
