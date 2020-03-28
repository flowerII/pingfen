package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SRoleDao;
import cn.qianshu.pingfen.dao.SUserDao;
import cn.qianshu.pingfen.entity.SRole;
import cn.qianshu.pingfen.entity.SUser;

@Service
public class UserService {

	@Autowired  
    private SUserDao sUserDao;
	
	@Autowired  
    private SRoleDao sRoleDao;
	
	public void addUser(SUser sUser) {
		//save user
		sUserDao.addUser(sUser);
		
		SUser u=sUserDao.findByName(sUser.getName());
		SRole r=sRoleDao.findByName("R_USER");
		// save user_role
		sUserDao.addUserRole(u.getId(), r.getId());
	}

	public void addUserRole(int id, int id2) {
		// TODO Auto-generated method stub
		sUserDao.addUserRole(id, id2);
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return sUserDao.getTotal();
	}

	public List<SUser> findByPage(int current_page, int page_size) {
		// TODO Auto-generated method stub
		return sUserDao.findByPage(current_page,page_size);
	}

	public List<SUser> findAll() {
		// TODO Auto-generated method stub
		return sUserDao.findAll();
	}

	public List<SUser> findByID(List<Integer> users) {
		// TODO Auto-generated method stub
		return sUserDao.findByID(users);
	}

	public void addActivityUser(Integer activity_id, int user_id, String user_name) {
		// TODO Auto-generated method stub
		sUserDao.addActivityUser(activity_id,user_id,user_name);
	}

	public SUser findByName(String user_name) {
		// TODO Auto-generated method stub
		return sUserDao.findByName(user_name);
	}

}
