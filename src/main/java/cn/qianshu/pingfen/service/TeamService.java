package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.STeamDao;
import cn.qianshu.pingfen.entity.Team;

@Service
public class TeamService {

	@Autowired  
    private STeamDao sTeamDao;

	public int getTotal() {
		// TODO Auto-generated method stub
		return sTeamDao.getTotal();
	}

	public void addTeam(String name) {
		// TODO Auto-generated method stub
		sTeamDao.addTeam(name);
	}

	public List<Team> findByPage(int start, int page_size) {
		// TODO Auto-generated method stub
		return sTeamDao.findByPage(start,page_size);
	}

	public List<Team> findAll() {
		// TODO Auto-generated method stub
		return sTeamDao.findAll();
	}

	public List<Team> findByID(List<Integer> teams) {
		// TODO Auto-generated method stub
		return sTeamDao.findByID(teams);
	}

	public void addActivityTeam(Integer activity_id, Integer team_id, String team_name) {
		// TODO Auto-generated method stub
		sTeamDao.addActivityTeam(activity_id,team_id,team_name);
	}

	public Team findByTeamID(int team_id) {
		// TODO Auto-generated method stub
		return sTeamDao.findByTeamID(team_id);
	}

	public List<Team> findByActivity(int activity_id) {
		// TODO Auto-generated method stub
		return sTeamDao.findByActivity(activity_id);
	}
	
}
