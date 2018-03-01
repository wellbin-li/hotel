package cn.it.hotel.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.service.RoomcategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class RoomcategoryServiceImplTest {

	@Resource
	private RoomcategoryService roomcategoryService;
	

	
	@Test
	public void getCount() {
		for(Roomcategory temp:roomcategoryService.queryJoinUser("",2,2)){
			System.out.println(temp + "," + temp.getUser());
			System.out.println(roomcategoryService.getCount(""));
		}
	}


}
