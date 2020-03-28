package cn.qianshu.pingfen.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.pingfen.entity.Act_add;
import cn.qianshu.pingfen.entity.Activity;
import cn.qianshu.pingfen.entity.Item;
import cn.qianshu.pingfen.entity.SItem;
import cn.qianshu.pingfen.entity.SScore;
import cn.qianshu.pingfen.entity.STotal;
import cn.qianshu.pingfen.entity.SUser;
import cn.qianshu.pingfen.entity.Team;
import cn.qianshu.pingfen.service.ActivityService;
import cn.qianshu.pingfen.service.ItemService;
import cn.qianshu.pingfen.service.KoufenService;
import cn.qianshu.pingfen.service.ScoreService;
import cn.qianshu.pingfen.service.TeamService;
import cn.qianshu.pingfen.service.TotalService;
import cn.qianshu.pingfen.service.UserService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	private static Logger log = LoggerFactory.getLogger(ActivityController.class);
	
	@Autowired
    ActivityService activityService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	TotalService totalService;
	
	@Autowired
	ScoreService scoreService;
	
	@Autowired
	KoufenService koufenService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/init", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> init(){
		log.info("add activity get teams and users!!!");
		List<Team> teams=teamService.findAll();
		List<SUser> users=userService.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("teams",teams);
		map.put("users",users);
		return map; 
	}
	
	//activity list
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> activity_admin(@RequestParam("page_size")int page_size,@RequestParam("current_page")int current_page) {
		log.info("activity controller get user by page size:"+page_size+",current_page:"+current_page);

	    int total=activityService.getTotal();
	    List<Activity> activities=activityService.findByPage((current_page-1)*page_size,page_size);
	    
	    Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("total",total);
		map.put("list",activities);
		return map; 
	}
	
	//activity add 
	/*@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody String add(@RequestParam("name") String name,@RequestParam("holdtime") String holdtime,@RequestParam("holdaddress") String holdaddress
			,@RequestParam("avg") boolean avg,@RequestParam("koufen") boolean koufen,@RequestParam("users") List<Integer> users,
			@RequestParam("teams_join") List<Integer> teams_join,ModelMap model) throws ParseException {
		log.info("activity controller add activity");
		log.info("params:"+name+",holdtime:"+holdtime+",holdaddress:"+holdaddress+",avg:"+avg+",koufen:"+koufen);
		for(int i:teams_join) {
			log.info("team:"+i);
		}
		activityService.addActivity(name,holdaddress,avg,koufen,sdf.parse(holdtime));
		log.info("test!!");
		activityService.addUsersByName(name,box2View);
		log.info("test!!");
		ScoreCollect scoreitem1=new ScoreCollect();
    	scoreitem1.setActivity(activity);
    	scoreitem1.setTeam(team);
		return "1"; 
	}*/
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(@RequestBody Act_add a) throws ParseException{
		log.info("add activity info:"+a.toString());
		Activity activity=new Activity(a.getName(), a.getHoldaddress(), a.isAvg(), a.isKoufen(),sdf.parse(a.getHoldtime()));
		activityService.addActivity(activity);
		
		//get activity id
		Activity act=activityService.findActivityByName(a.getName());
		log.info("get activity info:"+act.toString());
		
		//add team
		List<Team> teams=teamService.findByID(a.getTeams());
		for(Team t:teams) {
			log.info("team:"+t.getId()+",name:"+t.getName());
			teamService.addActivityTeam(act.getId(),t.getId(),t.getName());
		}
		
		//add users
		List<SUser> users=userService.findByID(a.getUsers());
		for(SUser u:users) {
			log.info("user:"+u.getId()+",name:"+u.getName());
			userService.addActivityUser(act.getId(),u.getId(),u.getName());
		}
		
		//add items
		for(Item i:a.getItems()) {
			log.info("add activity item:"+i.getName()+",scale:"+i.getScale1());
			itemService.addItem(act.getId(),i.getName(),i.getScale1());
    	}
		
		//init comment total
		for(Team t:teams) {
			log.info("team:"+t.getId()+",name:"+t.getName());
			koufenService.initKoufen(act.getId(), act.getName(), t.getId(), t.getName());
		}
		
		//init koufen
		for(Team t:teams) {
			log.info("team:"+t.getId()+",name:"+t.getName());
			for(SUser u:users) {
				log.info("user:"+u.getId()+",name:"+u.getName());
				totalService.initTotal(act.getId(), act.getName(), u.getId(), u.getName(), t.getId(),t.getName());
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		return map; 
	}
	
	//根据用户名查找未过期的活动
	@RequestMapping(value = "/get_by_useruanme", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> fingActivitybyUserName(Principal user){
		log.info("activity controller getactivity get_by_useruanme:"+user.getName());
		List<Activity> activitys= activityService.findbyUserName(user.getName());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",activitys);
		return map; 
	}
	
	//首页根据id及登录用户进入评分页面
	@RequestMapping(value = "/find_by_activityid", method=RequestMethod.GET)
	public String find_by_activityid(@RequestParam("id")int id,@RequestParam("username")String username,ModelMap model) {
		log.info("activity controller find_by_activity_id:"+id+",username:"+username);
		Activity activity=this.activityService.findByID(id);
		model.addAttribute("user", username);
		model.addAttribute("activity", activity);
		log.info("user:"+username);
		log.info("activity:"+activity.toString());
		return "vue/activity_team"; 
	}
	
	//根据活动ID获取参与队伍
	@RequestMapping(value = "/find_total_by_user_name_and_activity_name", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> find_total_by_user_name_and_activity_name(@RequestParam("user_name")String user_name,@RequestParam("activity_name")String activity_name) {
		log.info("find_total_by_user_name_and_activity_name:"+user_name+",activity_name:"+activity_name);
		List<STotal> total_list=totalService.find_total_by_user_name_and_activity_name(user_name,activity_name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",total_list);
		return map; 
	}
	
	//comment
	@RequestMapping(value = "/comment/{user_name}/{activity_name}/{team_id}", method=RequestMethod.GET)
	public String comment(@PathVariable("activity_name")String activity_name,@PathVariable("user_name")String user_name,@PathVariable("team_id")int team_id,ModelMap model) {
		log.info("activity controller comment and activity_name :"+activity_name+";username:"+user_name+";team_id:"+team_id);
		Activity activity=activityService.findActivityByName(activity_name);
		SUser user=userService.findByName(user_name);
		
		Team team=teamService.findByTeamID(team_id);
		
		List<SItem> s_items=itemService.getAllScoreItemByActivity(activity.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("activity", activity);
		model.addAttribute("team", team);
		model.addAttribute("i_length", s_items.size());
		log.info("user:"+user.toString());
		log.info("activity:"+activity.toString());
		return "vue/activity_comment"; 
	}
	
	@RequestMapping(value="/get_items",method=RequestMethod.GET)
	public @ResponseBody  Map<String, Object> get_items(@RequestParam("activity_id")int activity_id){
		log.info("get items activity_id:"+activity_id);
		List<SItem> s_items=itemService.getAllScoreItemByActivity(activity_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",s_items);
		return map; 
	}
	
	//提交评分
	@RequestMapping(value = "/submit", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submit(@RequestParam("user_id") int user_id,@RequestParam("activity_id") int activity_id,@RequestParam("team_id") int team_id,
			@RequestParam("user_name") String user_name,@RequestParam("activity_name") String activity_name,@RequestParam("team_name") String team_name,
			@RequestParam("models") List<Integer> scores){
		log.info("activity comment!!");
		log.info("user_id:"+user_id+",activity_id:"+activity_id+",team_id:"+team_id+",scores:"+scores.size());
		log.info("user_name:"+user_name+",activity_name:"+activity_name+",team_name:"+team_name);
		List<SItem> s_items=itemService.getAllScoreItemByActivity(activity_id);
		int size=s_items.size()+1;
		SScore c=null;
		for(int i=0;i<size;i++) {
			if(i==0) {
				
			}else {
				log.info("model:"+scores.get(i));
				c=new SScore(activity_id,activity_name,user_id,user_name,team_id,team_name,s_items.get(i-1).getId(),s_items.get(i-1).getName(),scores.get(i));
				scoreService.addScore(c);
			}
		}
		
		//提交之后，计算和
		totalService.caculate(activity_id, team_id, user_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		return map; 
	}
}