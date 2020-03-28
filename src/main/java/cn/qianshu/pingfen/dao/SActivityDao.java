package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.Activity;

@Mapper  
public interface SActivityDao {

	@Insert(value = " insert into s_activity (name,holdaddress,avg,koufen,holdtime,active)values(#{name},#{holdaddress},#{avg},#{koufen},#{holdtime},1)")
	void addActivity(Activity activity);

	@Select(value = " SELECT a.* FROM s_activity a WHERE a.name = #{name} ")
	Activity findActivityByName(@Param("name")String name);

	@Select(value = " SELECT count(1) FROM s_activity a")
	int getTotal();

	@Select(value = " SELECT a.* FROM s_activity a order by a.id limit #{i}, #{page_size}")
	List<Activity> findByPage(@Param("i")int i, @Param("page_size")int page_size);

	@Select(value = " SELECT a.* FROM s_activity a " + 
			"LEFT JOIN s_activity_user au ON a.id = au.activity_id " + 
			"left join s_user u on au.user_id=u.id " + 
			"where u.name=#{username} and a.active=1 ORDER BY a.id")
	List<Activity> findbyUserName(@Param("username")String username);

	@Select(value = " SELECT a.* FROM s_activity a WHERE a.id = #{id} ")
	Activity findByID(@Param("id")int id);

	@Select(value = " SELECT a.* FROM s_activity a where a.koufen =1 order by id desc")
	List<Activity> findAllKoufen();

	@Select(value = " SELECT a.* FROM s_activity a order by a.id desc")
	List<Activity> findAll();
 
}