package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.SPermission;

@Mapper  
public interface SPermissionDao {  

    @Select(value=" SELECT * FROM s_permission sp " +   
            " LEFT JOIN s_role_permission srp ON sp.id = srp.fk_permission_id " +   
            " LEFT JOIN s_role sr ON srp.fk_role_id = sr.id " +   
            " LEFT JOIN s_user_role sur ON sr.id = sur.fk_role_id " +   
            " LEFT JOIN s_user su ON sur.fk_user_id = su.id " +   
            " WHERE su.id = #{sUserId} ")  
    public List<SPermission> findSPermissionListBySUserId(int sUserId);  

    @Select(value=" SELECT * FROM s_permission sp WHERE sp.url = #{sUserId} ")  
    public List<SPermission> findSPermissionListBySPermissionUrl(String sPermissionUrl);  
}