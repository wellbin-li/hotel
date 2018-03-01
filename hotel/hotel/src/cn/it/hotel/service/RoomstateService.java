package cn.it.hotel.service;

import java.util.List;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.model.Roomstate;

public interface RoomstateService extends BaseService<Roomstate> {

		public List<Roomstate> queryRoomstate(String rsname,int page,int size);
		//根据关键字查询总记录数
		public Long getCount(String rsname);
		//根据ids删除多条记录
		public void deleteByRsids(String rsids);
}
