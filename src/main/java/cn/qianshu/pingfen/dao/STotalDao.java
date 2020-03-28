package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.STotal;

@Mapper  
public interface STotalDao {

	@Select(value = " SELECT t.* FROM s_total t WHERE t.user_name = #{user_name} and t.activity_name =#{activity_name}")
	List<STotal> find_total_by_user_name_and_activity_name(@Param("user_name")String user_name, @Param("activity_name")String activity_name);

	@Insert(value = " UPDATE s_total t SET t.total =" + 
			" (SELECT sum(s.score) total FROM s_score s WHERE s.activity_id = #{activity_id} AND s.user_id = #{user_id} AND s.team_id = #{team_id}) " + 
			" WHERE t.activity_id = #{activity_id} AND t.user_id = #{user_id} AND t.team_id = #{team_id}")
	void caculate(@Param("activity_id")int activity_id, @Param("team_id")int team_id, @Param("user_id")int user_id);

	@Insert(value = " insert into s_total (activity_id,activity_name,user_id,user_name,team_id,team_name,total)"
			+ "values(#{activity_id},#{activity_name},#{user_id},#{user_name},#{team_id},#{team_name},0)")
	void initTotal(@Param("activity_id")int activity_id, @Param("activity_name")String activity_name,@Param("user_id")int user_id,
			@Param("user_name")String user_name, @Param("team_id")int team_id,@Param("team_name")String team_name);
 
}