package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SKoufenDao;
import cn.qianshu.pingfen.entity.Koufen;

@Service
public class KoufenService {

	@Autowired  
    private SKoufenDao sKoufenDao;

	public void initKoufen(Integer activity_id, String activity_name, Integer team_id, String team_name) {
		// TODO Auto-generated method stub
		sKoufenDao.initKoufen(activity_id,activity_name,team_id,team_name);
	}

	public void updateKoufen(Integer activity_id, Integer team_id, Integer koufen) {
		// TODO Auto-generated method stub
		sKoufenDao.updateKoufen(activity_id,team_id,koufen);
	}

	public List<Koufen> findByActivity(int id) {
		// TODO Auto-generated method stub
		return sKoufenDao.findByActivity(id);
	}

}
