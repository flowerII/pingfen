package cn.qianshu.pingfen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.pingfen.entity.SUser;
import cn.qianshu.pingfen.service.RoleService;
import cn.qianshu.pingfen.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired 
    BCryptPasswordEncoder passwordEncoder;
	
	//user admin 
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> user_admin(@RequestParam("page_size")int page_size,@RequestParam("current_page")int current_page) {
		logger.info("user controller get user by page size:"+page_size+",current_page:"+current_page);
		
	    int total=userService.getTotal();
	    List<SUser> users=userService.findByPage((current_page-1)*page_size,page_size);
	    
	    Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("total",total);
		map.put("users",users);
		return map;  
	}
	
	//user add
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> user_add(@RequestBody SUser user) {
		logger.info("user controller add user :"+user.toString());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	userService.addUser(user);

    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("state",true);
		return map;
	}
}