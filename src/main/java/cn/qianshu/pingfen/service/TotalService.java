package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.STotalDao;
import cn.qianshu.pingfen.entity.STotal;

@Service
public class TotalService {

	@Autowired  
    private STotalDao sTotalDao;

	public List<STotal> find_total_by_user_name_and_activity_name(String user_name, String activity_name) {
		// TODO Auto-generated method stub
		return sTotalDao.find_total_by_user_name_and_activity_name(user_name,activity_name);
	}

	public void caculate(int activity_id, int team_id, int user_id) {
		// TODO Auto-generated method stub
		sTotalDao.caculate(activity_id, team_id, user_id);
	}

	public void initTotal(int activity_id, String activity_name, int user_id, String user_name, int team_id,String team_name) {
		// TODO Auto-generated method stub
		sTotalDao.initTotal(activity_id, activity_name, user_id, user_name, team_id, team_name);
	}
}
