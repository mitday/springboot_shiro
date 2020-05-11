package top.mitday.shiro_combat.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import top.mitday.shiro_combat.entity.Role;

import java.util.List;

@Repository
public interface RoleMapper {

    @Select("select ur.role_id id,r.name name,r.description description " +
            "from user_role ur " +
            "left join role r on ur.role_id = r.id " +
            "where ur.user_id = #{userId}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "permissionList",column = "id",
            many = @Many(select = "top.mitday.shiro_combat.mapper.PermissionMapper.findPermissionListByRoleId",fetchType = FetchType.DEFAULT))
    })
    List<Role> findRoleListByUserId(@Param("userId")int userId);
}
