package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.SRole;

@Mapper  
public interface SRoleDao {  

    @Select(value=" SELECT sr.* FROM s_role sr " +   
                    " LEFT JOIN s_user_role sur ON sr.id = sur.fk_role_id " +   
                    " LEFT JOIN s_user su ON sur.fk_user_id = su.id " +   
                    " WHERE su.id = #{sUserId} ")  
    public List<SRole> findSRoleListBySUserId(int sUserId);  

    @Select(value=" SELECT sr.* FROM s_role sr " +   
                    " LEFT JOIN s_role_permission srp ON sr.id = srp.fk_role_id " +   
                    " LEFT JOIN s_permission sp ON srp.fk_permission_id = sp.id " +   
                    " WHERE sp.url = #{sPermissionUrl} ")  
    public List<SRole> findSRoleListBySPermissionUrl(String sPermissionUrl);

    @Select(value=" SELECT sr.* FROM s_role sr where sr.role= #{name}")
	public SRole findByName(String name);  
}