package cn.it.hotel.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.hotel.model.Roomcategory;

@Controller
@Scope("prototype")
public class RoomcategoryAction extends BaseAction<Roomcategory> {
	
	public String query(){
		jsonList=roomcategoryService.query();
		return "jsonList";
	}
	
	public String queryJoinUser(){
		//用来存储分页的数据
		pageMap=new HashMap<String, Object>();
		System.out.println("rcname:"+model.getRcname());
		//根据关键字和分页的参数查询相应的数据
		List<Roomcategory> roomcategoryList=roomcategoryService.queryJoinUser(model.getRcname(), page, rows);
		pageMap.put("rows", roomcategoryList);
		//根据关键字查询总记录数
		pageMap.put("total", roomcategoryService.getCount(model.getRcname()));
		return "jsonMap1";
	}
	
	public String deleteByRcids(){
		System.out.println("删除rcid为:"+rcids);
		roomcategoryService.deleteByRcids(rcids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		System.out.println(model);
		roomcategoryService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		roomcategoryService.update(model);
	}
}
