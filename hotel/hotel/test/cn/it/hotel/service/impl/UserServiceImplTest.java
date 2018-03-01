package cn.it.hotel.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.hotel.model.User;
import cn.it.hotel.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class UserServiceImplTest {

	@Resource
	private UserService userService;
	
//	@Test
//	public void testQuery(){
//		for(User user: userService.query()){
//			System.out.println(user.toString());
//		}
//	}
//	
//	@Test
//	public void testSave() {
//		userService.save(new User("user2", "lwb", "user2", 0, "17827282729", 1, 0));
//	}
//	
//	@Test
//	public void testDelete(){
//		userService.delete(3);
//	}
//	
//	@Test
//	public void getCount(){
//		System.out.println(userService.getCount(""));
//	}
	
//	@Test
//	public void updateUstate(){
//		userService.updateUsate("admin", 0);
//		
//	}
	
	@Test
	public void setRoomcategoryRcuidNull(){
		userService.setRoomcategoryRcuidNull("2");
		
	}
	
	

}
