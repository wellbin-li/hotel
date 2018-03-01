package cn.it.hotel.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.hotel.model.Client;
import cn.it.hotel.model.User;

@Controller
@Scope("prototype")
public class ClientAction extends BaseAction<Client> {

	public String query(){
		jsonList=clientService.query();
		return "jsonList";
	}
	
	public String queryClient(){
		pageMap=new HashMap<String, Object>();
		System.out.println("uname:"+model.getCname());
		List<Client> clientList=clientService.queryClient(model.getCname(), page, rows);
		pageMap.put("rows", clientList);
		pageMap.put("total", clientService.getCount(model.getCname()));
		return "jsonMap";
	}
	
	public String deleteByCids(){
		System.out.println("删除cid为:"+cids);
		clientService.deleteByCids(cids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		System.out.println(model);
		clientService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		clientService.update(model);
	}
}
