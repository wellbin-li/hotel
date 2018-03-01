package cn.it.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.hotel.model.Business;
import cn.it.hotel.service.BusinessService;

@SuppressWarnings("unchecked")
@Service("BusinessService")
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements
		BusinessService {


	@Override
	public List<Business> queryJoinRoomAndRoomcategoryAndClientAndUser(String bname,
			int page, int size) {
		String hql="FROM Business b LEFT JOIN FETCH b.room LEFT JOIN FETCH b.roomcategory LEFT JOIN FETCH b.client LEFT JOIN FETCH b.user WHERE b.bname LIKE :bname GROUP BY b.bid";
		return getSession().createQuery(hql)
				.setString("bname", "%" + bname + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String bname) {
		String hql="SELECT count(b) FROM Business b WHERE b.bname LIKE :bname";
		return (Long)getSession().createQuery(hql)
				.setString("bname", "%" + bname + "%")
				.uniqueResult();
	}

	@Override
	public void deleteByBids(String bids) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Object> queryIncome(int number) {
		String hql="SELECT DATE_FORMAT(b.btime,'%Y-%m-%d'),sum(b.bfee) FROM Business b WHERE b.bname='开房'or b.bname='入住' GROUP BY DATE_FORMAT(b.btime,'%Y-%m-%d')";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}
	
	@Override
	public List<Object> querySale(int number) {
		String hql="SELECT b.roomcategory.rcname,sum(b.bnumber) FROM Business b JOIN b.roomcategory WHERE b.bname='开房'or b.bname='入住' GROUP BY b.roomcategory.rcid";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}
	
	@Override
	public List<Object> queryOrderin(int number) {
		String hql="SELECT b.roomcategory.rcname,sum(b.bnumber) FROM Business b JOIN b.roomcategory WHERE b.bname='订房' GROUP BY b.roomcategory.rcid";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}
	
	@Override
	public List<Object> queryOrderout(int number) {
		String hql="SELECT b.roomcategory.rcname,sum(b.bnumber) FROM Business b JOIN b.roomcategory WHERE b.bname='退订' GROUP BY b.roomcategory.rcid";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.list();
	}

}
