package top.mitday.shiro_combat.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.mitday.shiro_combat.entity.Permission;

import java.util.List;

@Repository
public interface PermissionMapper {

    @Select("select p.id id,p.name name,p.url url from role_permission rp " +
            "left join permission p on rp.permission_id = p.id " +
            "where rp.role_id = #{roleId}")
    List<Permission> findPermissionListByRoleId(@Param("roleId")int roleId);
}
