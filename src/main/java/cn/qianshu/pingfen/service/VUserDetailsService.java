package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.entity.SPermission;
import cn.qianshu.pingfen.entity.SRole;
import cn.qianshu.pingfen.entity.SUser;
import cn.qianshu.pingfen.entity.VUserDetails;

@Service  
public class VUserDetailsService implements UserDetailsService {  
  
    @Autowired  
    SecurityDataService securityDataService;  
    /** 
     * 根据用户输入的用户名返回数据源中用户信息的封装，返回一个UserDetails 
     */  
    @Override  
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  
        SUser sUser = securityDataService.findSUserByName(username);  
        //用户角色列表  
        List<SRole> sRoleList = securityDataService.findSRoleListBySUserId(sUser.getId());  
        //用户资源权限列表  
        List<SPermission> sPermissionList = securityDataService.findSPermissionListBySUserId(sUser.getId());  
        return new VUserDetails(sUser, sRoleList, sPermissionList);  
    }  
  
}
