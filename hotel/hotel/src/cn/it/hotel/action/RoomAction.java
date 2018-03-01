package cn.it.hotel.action;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.hotel.model.Business;
import cn.it.hotel.model.Room;
import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.model.Roomstate;

@Controller
@Scope("prototype")
public class RoomAction extends BaseAction<Room> {

	public String queryJoinRoomcategoryAndRoomsateAndClientAndUser(){
		pageMap=new HashMap<String, Object>();
		System.out.println("rname:"+model.getRname());
		List<Room> roomList=roomService.queryJoinRoomcategoryAndRoomsateAndClientAndUser(model.getRname(), page, rows);
		pageMap.put("rows", roomList);
		pageMap.put("total", roomService.getCount(model.getRname()));
		return "jsonMap";
	}
	
	public String deleteByRids(){
		System.out.println("删除rid为:"+rids);
		roomService.deleteByRids(rids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	//客房开房业务
	public void roomin(){
		System.out.println("-----------------bremark的值：---------------------"+bremark);
		System.out.println(model);
		//设置房间状态
		model.setRoomstate(roomstate3);
		roomService.update(model);
		//获取当前时间戳
//		Date date=new Date();
//		Timestamp time=new Timestamp(date.getTime());
		Business b=new Business("开房", model.getClient(), model, model.getRoomcategory(), model.getRdate(), model.getRnumber(), model.getRcash(), model.getRfee(), bremark, model.getUser());
		businessService.save(b);
		System.out.println("开房，存储业务："+b);
	}
	
	//客房入住业务
	public void roomjoin(){
		System.out.println("-----------------bremark的值：---------------------"+bremark);
		System.out.println(model);
		//设置房间状态
		model.setRoomstate(roomstate3);
		roomService.update(model);
		//获取当前时间戳
//		Date date=new Date();
//		Timestamp time=new Timestamp(date.getTime());
		Business b=new Business("入住", model.getClient(), model, model.getRoomcategory(), model.getRdate(), model.getRnumber(), model.getRcash(), model.getRfee(), bremark, model.getUser());
		businessService.save(b);
		System.out.println("入住，存储业务："+b);
	}
	
	//客房退房业务
	public void roomout(){
		System.out.println("-----------------bremark的值：---------------------"+bremark);
		System.out.println("room修改前："+model);
		//设置房间状态
		model.setRoomstate(roomstate1);
		Business b=new Business("退房", model.getClient(), model, model.getRoomcategory(), model.getRdate(), model.getRnumber(), model.getRcash(), model.getRfee(), bremark, model.getUser());
		businessService.save(b);
		model.setClient(null);
		model.setRnumber(null);
		model.setRdate(null);
		model.setRcash(null);
		model.setRfee(null);
		model.setUser(null);
		System.out.println("room修改后："+model);
		roomService.update(model);
		System.out.println("退房，存储业务："+b);
	}
	
	//客房退订业务
	public void orderout(){
		System.out.println("-----------------bremark的值：---------------------"+bremark);
		System.out.println("room修改前："+model);
		//设置房间状态
		model.setRoomstate(roomstate1);
		Business b=new Business("退订", model.getClient(), model, model.getRoomcategory(), model.getRdate(), model.getRnumber(), model.getRcash(), model.getRfee(), bremark, model.getUser());
		businessService.save(b);
		model.setClient(null);
		model.setRnumber(null);
		model.setRdate(null);
		model.setRcash(null);
		model.setRfee(null);
		model.setUser(null);
		System.out.println("room修改后："+model);
		roomService.update(model);
		System.out.println("退订，存储业务："+b);
	}
	
	
	
	//客房预订业务
	public void orderin(){
		System.out.println("-----------------bremark的值：---------------------"+bremark);
		System.out.println(model);
		//设置房间状态
		model.setRoomstate(roomstate2);
		roomService.update(model);
		Business b=new Business("订房", model.getClient(), model, model.getRoomcategory(), model.getRdate(), model.getRnumber(), model.getRcash(), model.getRfee(), bremark, model.getUser());
		businessService.save(b);
		System.out.println("订房，存储业务："+b);
	}
	
	public void save(){
		System.out.println(model);
		roomService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		roomService.update(model);
	}
}
