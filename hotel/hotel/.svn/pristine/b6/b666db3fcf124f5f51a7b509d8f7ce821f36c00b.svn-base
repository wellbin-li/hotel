package cn.it.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.hotel.model.Roomstate;
import cn.it.hotel.service.RoomstateService;

@SuppressWarnings("unchecked")
@Service("RoomstateService")
public class RoomstateServiceImpl extends BaseServiceImpl<Roomstate> implements RoomstateService {

	@Override
	public List<Roomstate> queryRoomstate(String rsname, int page, int size) {
		String hql="FROM Roomstate r WHERE r.rsname LIKE :rsname";
		return getSession().createQuery(hql)
				.setString("rsname", "%" + rsname + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String rsname) {
		String hql="SELECT count(r) FROM Roomstate r WHERE r.rsname LIKE :rsname";
		return (Long)getSession().createQuery(hql)
				.setString("rsname", "%" + rsname + "%")
				.uniqueResult();
	}

	@Override
	public void deleteByRsids(String rsids) {
		String hql="DELETE FROM Roomstate WHERE rsid in (" + rsids + ")";
		getSession().createQuery(hql)
				.executeUpdate();
	}

}
