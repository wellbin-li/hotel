package cn.it.hotel.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.hotel.model.Business;
import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.service.BusinessService;
import cn.it.hotel.service.RoomcategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class BusinessServiceImplTest {

	@Resource
	private BusinessService businessService;
	

	
//	@Test
//	public void getCount() {
//			System.out.println(businessService.getCount(""));	
//	}
//
//	@Test
//	public void queryJoinClientAndRoomAndUser() {
//		for(Business temp: businessService.queryJoinRoomAndRoomcategoryAndClientAndUser("", 2, 3)){
//			System.out.println(temp);
//		}	
//	}
	
	@Test
	public void querySale(){
		System.out.println(JSONSerializer.toJSON(businessService.querySale(10)));
	}
	

}
