package cn.qianshu.pingfen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianshu.pingfen.dao.SItemDao;
import cn.qianshu.pingfen.entity.SItem;

@Service
public class ItemService {

	@Autowired  
    private SItemDao sItemDao;

	public void addItem(Integer activity_id, String name, int scale1) {
		// TODO Auto-generated method stub
		sItemDao.addItem(activity_id,name,scale1);
	}

	public List<SItem> getAllScoreItemByActivity(Integer activity_id) {
		// TODO Auto-generated method stub
		return sItemDao.getAllScoreItemByActivity(activity_id);
	}

}
