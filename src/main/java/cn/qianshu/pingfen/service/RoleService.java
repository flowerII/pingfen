package cn.qianshu.pingfen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SRoleDao;
import cn.qianshu.pingfen.entity.SRole;

@Service
public class RoleService {

	@Autowired  
    private SRoleDao sRoleDao;

	public SRole findByName(String name) {
		// TODO Auto-generated method stub
		return sRoleDao.findByName(name);
	}
}
