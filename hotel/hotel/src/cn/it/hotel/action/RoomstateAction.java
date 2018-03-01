package cn.it.hotel.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.model.Roomstate;

@Controller
@Scope("prototype")
public class RoomstateAction extends BaseAction<Roomstate> {

	public String query(){
		jsonList=roomstateService.query();
		return "jsonList";
	}
	
	public String queryRoomstate(){
		pageMap=new HashMap<String, Object>();
		System.out.println("rsname:"+model.getRsname());
		List<Roomstate> roomstateList=roomstateService.queryRoomstate(model.getRsname(), page, rows);
		pageMap.put("rows", roomstateList);
		pageMap.put("total", roomstateService.getCount(model.getRsname()));
		return "jsonMap";
	}
	
	public String deleteByRsids(){
		System.out.println("删除rsid为:"+rsids);
		roomstateService.deleteByRsids(rsids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		System.out.println(model);
		roomstateService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		roomstateService.update(model);
	}
}
