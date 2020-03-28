package cn.qianshu.pingfen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.qianshu.pingfen.entity.SUser;

@Mapper  
public interface SUserDao {  
 
	//账号查找，登录查询
    @Select(value = " SELECT su.* FROM s_user su WHERE su.account = #{name} ")  
    public SUser findSUserByName(String name);

    @Insert(value = " insert into s_user (name,password,account)values(#{name},#{password},#{account})")  
    public void addUser(SUser sUser);
	
	@Update(value = " update s_user set password = #{arg0} where account = #{arg1}")
	public void setPasswordByName(String password,String account);

	@Insert(value = " insert into s_user_role (fk_user_id,fk_role_id)values(#{user_id},#{role_id})")
	public void addUserRole(@Param("user_id")int user_id, @Param("role_id")int role_id);

	@Select(value = " SELECT su.* FROM s_user su WHERE su.name = #{name} ")  
	public SUser findByName(String name);

	@Select(value = " SELECT count(1) FROM s_user su")
	public int getTotal();

	@Select(value = " SELECT su.* FROM s_user su order by su.id limit #{current_page}, #{page_size}")
	public List<SUser> findByPage(@Param("current_page")int current_page, @Param("page_size")int page_size);

	@Select(value = " SELECT su.* FROM s_user su order by su.id")
	public List<SUser> findAll();

	@Select("<script>"
            + "SELECT * FROM s_user u WHERE u.id IN "
            + "<foreach item='item' index='index' collection='users' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
	public List<SUser> findByID(@Param("users")List<Integer> users);

	@Select(value = " insert into s_activity_user (activity_id,user_id,user_name)values(#{activity_id},#{user_id},#{user_name})")
	public void addActivityUser(@Param("activity_id")Integer activity_id, @Param("user_id")int user_id, @Param("user_name")String user_name);
  
}