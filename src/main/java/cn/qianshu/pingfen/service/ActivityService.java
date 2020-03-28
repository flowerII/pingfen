package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SActivityDao;
import cn.qianshu.pingfen.entity.Activity;

@Service
public class ActivityService {

	@Autowired  
    private SActivityDao sActivityDao;

	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		sActivityDao.addActivity(activity);
	}

	public Activity findActivityByName(String name) {
		// TODO Auto-generated method stub
		return sActivityDao.findActivityByName(name);
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return sActivityDao.getTotal();
	}

	public List<Activity> findByPage(int i, int page_size) {
		// TODO Auto-generated method stub
		return sActivityDao.findByPage(i,page_size);
	}

	public List<Activity> findbyUserName(String username) {
		// TODO Auto-generated method stub
		return sActivityDao.findbyUserName(username);
	}

	public Activity findByID(int id) {
		// TODO Auto-generated method stub
		return sActivityDao.findByID(id);
	}

	public List<Activity> findAllKoufen() {
		// TODO Auto-generated method stub
		return sActivityDao.findAllKoufen();
	}

	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return sActivityDao.findAll();
	}

}
