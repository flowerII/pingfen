package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.Rank;

@Mapper  
public interface SRankDao {

	@Delete(value = " delete FROM s_rank WHERE activity_id = #{id} ")
	void deleteByActivity(int id);

	@Select(value = " select r.* FROM s_rank r WHERE r.activity_id = #{id} order by id desc")
	List<Rank> findByActivity(int id);

	@Insert(value = " insert into s_rank (activity_id,activity_name,team_id,team_name,max_,min_,avg_,koufen,last_) SELECT t.activity_id,"
			+ " t.activity_name, t.team_id, t.team_name, max(t.total) max_, min(t.total) min_, ( sum(t.total) - max(t.total) - min(t.total)) / (count(1) - 2) avg_, "
			+ " k.koufen koufen, (( sum(t.total) - max(t.total) - min(t.total)) / (count(1) - 2) - k.koufen ) last_ FROM s_total t, s_koufen k "
			+ " WHERE t.activity_id = #{id} AND k.activity_id = t.activity_id AND k.team_id = t.team_id GROUP BY t.activity_id, t.activity_name, t.team_id, t.activity_name")
	void updateRank4(int id);

	@Insert(value = " insert into s_rank (activity_id,activity_name,team_id,team_name,max_,min_,avg_,last_) SELECT t.activity_id, t.activity_name, t.team_id, t.team_name, max(t.total) max_, min(t.total) min_,"
			+ " ( sum(t.total) - max(t.total) - min(t.total)) / (count(1) - 2) avg_,( sum(t.total) - max(t.total) - min(t.total)) / (count(1) - 2) last_ FROM s_total t WHERE t.activity_id = #{id} "
			+ "GROUP BY t.activity_id, t.activity_name, t.team_id, t.activity_name")
	void updateRank3(int id);

	@Insert(value="insert into s_rank (activity_id,activity_name,team_id,team_name,avg_,koufen,last_) " + 
			"select t.activity_id, t.activity_name,t.team_id,t.team_name,t.total avg_,k.koufen koufen,(t.total-k.koufen)last_ from s_total t,s_koufen k "
			+ "where t.activity_id=#{id} AND k.activity_id = t.activity_id AND k.team_id = t.team_id and t.user_id=1")
	void updateRank2(int id);

	@Insert(value="insert into s_rank (activity_id,activity_name,team_id,team_name,avg_,last_) " + 
			"select t.activity_id, t.activity_name,t.team_id,t.team_name,t.total avg_,t.total last_ from s_total  t where t.activity_id=#{id} and t.user_id=1")
	void updateRank1(int id);

	
}