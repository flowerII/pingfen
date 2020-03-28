package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SRankDao;
import cn.qianshu.pingfen.entity.Rank;

@Service
public class RankService {

	@Autowired  
    private SRankDao sRanklDao;

	public void deleteByActivity(int id) {
		// TODO Auto-generated method stub
		sRanklDao.deleteByActivity(id);
	}

	public List<Rank> findByActivity(int id) {
		// TODO Auto-generated method stub
		return sRanklDao.findByActivity(id);
	}

	public void updateRank4(int id) {
		// TODO Auto-generated method stub
		sRanklDao.updateRank4(id);
	}

	public void updateRank3(int id) {
		// TODO Auto-generated method stub
		sRanklDao.updateRank3(id);
	}

	public void updateRank2(int id) {
		// TODO Auto-generated method stub
		sRanklDao.updateRank2(id);
	}

	public void updateRank1(int id) {
		// TODO Auto-generated method stub
		sRanklDao.updateRank1(id);
	}
	
}
