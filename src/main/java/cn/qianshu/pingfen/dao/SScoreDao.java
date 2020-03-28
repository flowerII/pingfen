package cn.qianshu.pingfen.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import cn.qianshu.pingfen.entity.SScore;

@Mapper  
public interface SScoreDao {

	@Insert(value = " insert into s_score (activity_id,activity_name,user_id,user_name,team_id,team_name,item_id,item_name,score)"
			+ "values(#{activity_id},#{activity_name},#{user_id},#{user_name},#{team_id},#{team_name},#{item_id},#{item_name},#{score})")
	void addScore(SScore s);

}