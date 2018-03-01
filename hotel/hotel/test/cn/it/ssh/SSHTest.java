package cn.it.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.service.RoomcategoryService;
import cn.it.hotel.service.impl.RoomcategoryServiceImpl;

/**
 * 
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	@Resource
	private Date date;
	
	@Resource
	private RoomcategoryService roomcategoryService;
	
	@Test  //测试SpringIOC开发环境
	public void springIoc(){
		System.out.println(date);
	}
	
	
	@Test  //测试hibernate和Spring开发环境
	public void hibernateAndSpring(){
		roomcategoryService.update(new Roomcategory("总统套房",199.00,4,1));
	}
}
