package cn.it.hotel.service;

import java.util.List;

import cn.it.hotel.model.Roomcategory;

public interface RoomcategoryService extends BaseService<Roomcategory> {
	//查询类别信息，级联管理员
	public List<Roomcategory> queryJoinUser(String rcname,int page,int size);
	//根据关键字查询总记录数
	public Long getCount(String rcname);
	//根据ids删除多条记录
	public void deleteByRcids(String rcids);
}
