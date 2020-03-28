package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.Team;

@Mapper  
public interface STeamDao {

	@Select(value = " SELECT count(1) FROM s_team t")
	int getTotal();

	@Insert(value = " insert into s_team (name)values(#{name})")
	void addTeam(@Param("name")String name);

	@Select(value = " SELECT t.* FROM s_team t order by t.id limit #{start}, #{page_size}")
	List<Team> findByPage(@Param("start")int start, @Param("page_size")int page_size);

	@Select(value = " SELECT t.* FROM s_team t order by t.id ")
	List<Team> findAll();

	@Select("<script>"
            + "SELECT * FROM s_team t WHERE t.id IN "
            + "<foreach item='item' index='index' collection='teams' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
	List<Team> findByID(@Param("teams")List<Integer> teams);

	@Insert(value = " insert into s_activity_team (activity_id,team_id,team_name)values(#{activity_id},#{team_id},#{team_name})")
	void addActivityTeam(@Param("activity_id")Integer activity_id, @Param("team_id")Integer team_id, @Param("team_name")String team_name);

	@Select(value = " SELECT t.* FROM s_team t where t.id= #{team_id}")
	Team findByTeamID(int team_id);

	@Select(value = " SELECT t.team_id id,t.team_name name FROM s_activity_team t where t.activity_id= #{activity_id} order by t.id ")
	List<Team> findByActivity(int activity_id);  
 
}