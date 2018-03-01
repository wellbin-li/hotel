package cn.it.hotel.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.model.User;
import cn.it.hotel.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	public String query(){
		jsonList=userService.query();
		return "jsonList";
	}
	
	public String queryUser(){
		pageMap=new HashMap<String, Object>();
		System.out.println("uname:"+model.getUname());
		List<User> userList=userService.queryUser(model.getUname(), page, rows);
		pageMap.put("rows", userList);
		pageMap.put("total", userService.getCount(model.getUname()));
		return "jsonMap";
	}
	//根据id多条记录删除
	public String deleteByUids(){
		System.out.println("删除uid为:"+uids);
		userService.deleteByUids(uids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	//彻底删除数据库中当前session中的user
	public String deleteNowUser(){
		System.out.println("彻底删除用户："+nowUserUid);
		//必须先将客房类型中的管理员设为空值  然后再彻底删除管理员，否则会报错
		userService.setRoomcategoryRcuidNull(nowUserUid);
		userService.deleteByUids(nowUserUid);
		userService.logout();
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	//登录验证用户名和密码
	public String validateUser(){
		if(userService.validateUser(user, pass)){
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	//验证用户名是否已经存在
	public String validateUserUlogin(){
		System.out.println("验证用户名："+userUlogin);
		if(userService.validateUserUlogin(userUlogin)){
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	//修改用户密码时验证用户密码是否正确
	public String validateUserUpass(){
		System.out.println("验证用户:"+userUlogin+"的密码："+userUpass);
		if(userService.validateUserUpass(userUpass, userUlogin)){
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	//注销登录
	public String logout(){
		userService.logout();
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		System.out.println(model);
		userService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		userService.update(model);
	}
}
