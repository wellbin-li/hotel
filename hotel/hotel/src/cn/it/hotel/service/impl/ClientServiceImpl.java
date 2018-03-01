package cn.it.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.hotel.model.Client;
import cn.it.hotel.service.ClientService;

@SuppressWarnings("unchecked")
@Service("clientService")
public class ClientServiceImpl extends BaseServiceImpl<Client> implements ClientService {

	@Override
	public List<Client> queryClient(String cname, int page, int size) {
		String hql="FROM Client c WHERE c.cname LIKE :cname";
		return getSession().createQuery(hql)
				.setString("cname", "%" + cname + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String cname) {
		String hql="SELECT count(c) FROM Client c WHERE c.cname LIKE :cname";
		return (Long)getSession().createQuery(hql)
				.setString("cname", "%" + cname + "%")
				.uniqueResult();
	}
	
	@Override
	public void deleteByCids(String cids) {
		String hql="DELETE FROM Client WHERE cid in (" + cids + ")";
		getSession().createQuery(hql)
				.executeUpdate();
	}

}
