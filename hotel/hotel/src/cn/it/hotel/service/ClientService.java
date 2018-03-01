package cn.it.hotel.service;

import java.util.List;

import cn.it.hotel.model.Client;

public interface ClientService extends BaseService<Client> {

	 //查询客户信息，分页
	public List<Client> queryClient(String cname,int page,int size);
	//根据关键字查询总记录数
	public Long getCount(String cname);
	//根据ids删除多条记录
	public void deleteByCids(String cids);
}
