package cn.qianshu.pingfen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.pingfen.entity.Activity;
import cn.qianshu.pingfen.entity.Koufen;
import cn.qianshu.pingfen.entity.Rank;
import cn.qianshu.pingfen.entity.Team;
import cn.qianshu.pingfen.service.ActivityService;
import cn.qianshu.pingfen.service.ItemService;
import cn.qianshu.pingfen.service.KoufenService;
import cn.qianshu.pingfen.service.RankService;
import cn.qianshu.pingfen.service.ScoreService;
import cn.qianshu.pingfen.service.TeamService;
import cn.qianshu.pingfen.service.TotalService;
import cn.qianshu.pingfen.service.UserService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	private static Logger log = LoggerFactory.getLogger(CommentController.class);
	
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
	
	@Autowired
	RankService rankService;
	
	//进入扣分列表页面
	@RequestMapping(value = "/koufen_page", method=RequestMethod.GET)
	public String activity_add(ModelMap model) {
		log.info("进入扣分列表页面！！！");
		return "vue/koufen_list"; 
	}
	
	@RequestMapping(value = "/findAllKoufen", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> findAllKoufen() {
		log.info("查找所有需要扣分活动");
		List<Activity> activityList= activityService.findAllKoufen();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",activityList);
		return map;
	}
	
	//进入扣分列表页面
	@RequestMapping(value = "/koufen/{id}", method=RequestMethod.GET)
	public String koufen(ModelMap model,@PathVariable("id")int id) {
		log.info("进入扣分页面！！！");
		//List<Activity> activityList= activityService.findAllByKoufen(true);
		Activity a=activityService.findByID(id);
		
		List<Koufen> s_list=koufenService.findByActivity(id);
		model.addAttribute("i_length", s_list.size());
		model.addAttribute("activity", a);
		log.info("team size:"+s_list.size());
		return "vue/koufen"; 
	}
	
	// 获得扣分队伍
	@RequestMapping(value = "/get_koufen_team", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> get_koufen_(@RequestParam("activity_id")int activity_id) {
		log.info("查找扣分活动队伍:"+activity_id);
		
		List<Koufen> s_list=koufenService.findByActivity(activity_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",s_list);
		return map; 
	}
	
	//koufen_submit
	@RequestMapping(value = "/koufen_submit", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> koufen_submit(@RequestParam("models") List<Integer> koufens,@RequestParam("activity_id") int activity_id) {
		log.info("提交扣分  活动ID："+activity_id);
		Activity a=activityService.findByID(activity_id);
		List<Team> s_list=teamService.findByActivity(activity_id);
		int size=koufens.size();
		log.info("koufen tijiao size："+size);
		for(int i=0;i<size;i++) {
			if(i==0) {
				
			}else {
				log.info("队伍："+s_list.get(i-1).getName()+"扣分:"+koufens.get(i));
				koufenService.updateKoufen(a.getId(),s_list.get(i-1).getId(),koufens.get(i));
			}
		}
		
		//List<Score1> s_list=activityService.findSCore1AllByActivity(activity_name);;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		return map; 
	}
	
	//进入排名活动选择页面
	@RequestMapping(value = "/paiming", method=RequestMethod.GET)
	public String paiming(ModelMap model) {
		log.info("进入排名列表页面！！！");
		//List<Activity> activityList= activityService.findAllByKoufen(true);
		return "vue/paiming_list";
	}
	
	//统计页面，查找所有活动findAllAndOrderByIdDesc
	@RequestMapping(value = "/findAllActivity", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> findAllActivity() {
		log.info("查找所有活动");
		List<Activity> activityList= activityService.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("list",activityList);
		return map; 
	}
	
	//进入活动排名
	@RequestMapping(value = "/rank/{id}", method=RequestMethod.GET)
	public String rank(ModelMap model,@PathVariable("id")int id) { 
		log.info("进入活动排名！！！id:"+id);
		//List<Activity> activityList= activityService.findAllByKoufen(true);
		
		Activity a=activityService.findByID(id);	
		model.addAttribute("activity", a);
		log.info("avg:"+a.isAvg()+",koufen:"+a.isKoufen());
		if(a.isAvg()&&a.isKoufen()) {
			return "vue/rank4";
		}else if(a.isAvg()&&!a.isKoufen()) {
			return "vue/rank3";
		}else if(!a.isAvg()&&a.isKoufen()) {
			return "vue/rank2";
		}else {
			return "vue/rank1"; 
		}
		
	}
	
	//排名
	@RequestMapping(value = "/rank_data", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> rank_data(ModelMap model,@RequestParam("id")int id) { 
		log.info("活动排名！！！activity id:"+id);
		Activity a=activityService.findByID(id);
		//先删除原来的数据
		rankService.deleteByActivity(id);
		//重新生成数据
		log.info("avg:"+a.isAvg()+",koufen:"+a.isKoufen());
		if(a.isAvg()&&a.isKoufen()) {
			rankService.updateRank4(id);
		}else if(a.isAvg()&&!a.isKoufen()) {
			rankService.updateRank3(id);
		}else if(!a.isAvg()&&a.isKoufen()) {
			rankService.updateRank2(id);
		}else {
			rankService.updateRank1(id);
		}
		//获取
		List<Rank> rank_list=rankService.findByActivity(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status",true);
		map.put("activity",a);
		map.put("list",rank_list);
		return map; 
	}
}