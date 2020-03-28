package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.qianshu.pingfen.entity.Koufen;

@Mapper  
public interface SKoufenDao {

	@Insert(value = " insert into s_koufen (activity_id,activity_name,team_id,team_name,koufen)"
			+ "values(#{activity_id},#{activity_name},#{team_id},#{team_name},0)")
	void initKoufen(@Param("activity_id")Integer activity_id, @Param("activity_name")String activity_name, 
			@Param("team_id")Integer team_id, @Param("team_name")String team_name);

	@Update(value = " update s_koufen set koufen = #{koufen} where activity_id = #{activity_id} and team_id= #{team_id}")
	void updateKoufen(@Param("activity_id")Integer activity_id, @Param("team_id")Integer team_id,
			@Param("koufen")Integer koufen);

	@Select(value = " SELECT k.* FROM s_koufen k where k.activity_id= #{activity_id} order by k.id ")
	List<Koufen> findByActivity(int id);

}