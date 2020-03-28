package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.pingfen.entity.SItem;

@Mapper  
public interface SItemDao {

	@Insert(value = " insert into s_item (activity_id,name,scale1)values(#{activity_id},#{name},#{scale1})")
	void addItem(@Param("activity_id")Integer activity_id, @Param("name")String name, @Param("scale1")int scale1);

	@Select(value = " SELECT i.* FROM s_item i where i.activity_id = #{activity_id} order by id asc")
	List<SItem> getAllScoreItemByActivity(Integer activity_id);  
 
}