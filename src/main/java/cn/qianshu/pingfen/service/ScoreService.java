package cn.qianshu.pingfen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SScoreDao;
import cn.qianshu.pingfen.entity.SScore;

@Service
public class ScoreService {

	@Autowired  
    private SScoreDao sScoreDao;

	public void addScore(SScore s) {
		// TODO Auto-generated method stub
		sScoreDao.addScore(s);
	}

}
