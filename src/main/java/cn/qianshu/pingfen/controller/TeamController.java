package cn.qianshu.pingfen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.pingfen.entity.Team;
import cn.qianshu.pingfen.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	private static Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	TeamService teamService;
	
	//team admin 
		@RequestMapping(value = "/admin", method=RequestMethod.GET)
		public @ResponseBody Map<String, Object> user_admin(@RequestParam("page_size")int page_size,@RequestParam("current_page")int current_page) {
			logger.info("team controller get team by page size:"+page_size+",current_page:"+current_page);
			
		    int total=teamService.getTotal();
		    List<Team> teams=teamService.findByPage((current_page-1)*page_size,page_size);
		    Map<String, Object> map = new HashMap<String, Object>();
			map.put("status",true);
			map.put("total",total);
			map.put("list",teams);
			return map; 
		}
		
		//team add
		@RequestMapping(value = "/add", method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> team_add(@RequestBody Team team) {
			logger.info("team controller add team :"+team.getName());
			teamService.addTeam(team.getName());
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status",true);
			return map; 
		}
}