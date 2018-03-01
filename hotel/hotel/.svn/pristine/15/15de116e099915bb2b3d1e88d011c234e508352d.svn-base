package cn.it.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.service.RoomcategoryService;

@SuppressWarnings("unchecked")
@Service("RoomcategoryService")
public class RoomcategoryServiceImpl extends BaseServiceImpl<Roomcategory> implements RoomcategoryService {

	@Override
	public List<Roomcategory> queryJoinUser(String rcname, int page, int size) {
		String hql="FROM Roomcategory c LEFT JOIN FETCH c.user WHERE c.rcname LIKE :rcname GROUP BY c.rcid";
		return getSession().createQuery(hql)
				.setString("rcname", "%" + rcname + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String rcname) {
		String hql="SELECT count(c) FROM Roomcategory c WHERE c.rcname LIKE :rcname";
		return (Long)getSession().createQuery(hql)
				.setString("rcname", "%" + rcname + "%")
				.uniqueResult();
	}

	@Override
	public void deleteByRcids(String rcids) {
		String hql="DELETE FROM Roomcategory WHERE rcid in (" + rcids + ")";
		getSession().createQuery(hql)
				.executeUpdate();
	}

}
