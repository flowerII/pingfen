package cn.qianshu.pingfen.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.pingfen.entity.SUser;
import cn.qianshu.pingfen.service.SecurityDataService;

@Controller
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SecurityDataService securityDataService;
	
	@RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

	//登录首页
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String activity_admin(Principal user,ModelMap model) {
		logger.info("index page");
		model.addAttribute("username", user.getName());
		return "vue/admin"; 
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/user")  
    public @ResponseBody String doctor(@RequestBody SUser u) {  
    	BCryptPasswordEncoder bpe =new BCryptPasswordEncoder();
    	
    	logger.info("add user:"+u.getName()+"/"+u.getPassword());    	
    	String password=u.getPassword();
    	u.setPassword(bpe.encode(password));
    	securityDataService.addUser(u);
    	
        return "user";  
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/password")  
    public @ResponseBody String password(@RequestBody SUser u) {  
    	BCryptPasswordEncoder bpe =new BCryptPasswordEncoder();

    	logger.info("password user:"+u.getName()+"/"+u.getPassword());
    	securityDataService.setPasswordByName(bpe.encode(u.getPassword()), u.getName());

        return "password";  
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/init")  
    public @ResponseBody String init() {  
    	BCryptPasswordEncoder bpe =new BCryptPasswordEncoder();
    	logger.info("password :"+bpe.encode("123456"));

        return "success";  
    }

}
