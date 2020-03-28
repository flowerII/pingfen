package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SPermissionDao;
import cn.qianshu.pingfen.dao.SRoleDao;
import cn.qianshu.pingfen.dao.SUserDao;
import cn.qianshu.pingfen.entity.SPermission;
import cn.qianshu.pingfen.entity.SRole;
import cn.qianshu.pingfen.entity.SUser;

@Service  
public class SecurityDataService {  
    @Autowired  
    private SUserDao sUserDao;  
    @Autowired  
    private SRoleDao sRoleDao;  
    @Autowired  
    private SPermissionDao sPermissionDao;  
  
    public SUser findSUserByName(String name) {  
        return sUserDao.findSUserByName(name);  
    }  
  
    public List<SRole> findSRoleListBySUserId(int sUserId) {  
        return sRoleDao.findSRoleListBySUserId(sUserId);  
    }  
  
    public List<SRole> findSRoleListBySPermissionUrl(String sPermissionUrl) {  
        return sRoleDao.findSRoleListBySPermissionUrl(sPermissionUrl);  
    }  
  
    public List<SPermission> findSPermissionListBySUserId(int sUserId) {  
        return sPermissionDao.findSPermissionListBySUserId(sUserId);  
    }  
  
    public List<SPermission> findSPermissionListBySPermissionUrl(String sPermissionUrl) {  
        return sPermissionDao.findSPermissionListBySPermissionUrl(sPermissionUrl);  
    }

	public void addUser(SUser u) {
		// TODO Auto-generated method stub
		sUserDao.addUser(u);
	}
	
	public void setPasswordByName(String password,String account) {
    	sUserDao.setPasswordByName(password, account);
    }
}
