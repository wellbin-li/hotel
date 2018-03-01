package cn.it.hotel.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import cn.it.hotel.model.User;
import cn.it.hotel.service.UserService;

@SuppressWarnings("unchecked")
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	
	@Override
	public List<User> queryUser(String uname, int page, int size) {
		String hql="FROM User u WHERE u.uname LIKE :uname";
		return getSession().createQuery(hql)
				.setString("uname", "%" + uname + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String uname) {
		String hql="SELECT count(u) FROM User u WHERE u.uname LIKE :uname";
		return (Long)getSession().createQuery(hql)
				.setString("uname", "%" + uname + "%")
				.uniqueResult();
	}

	@Override
	public void deleteByUids(String uids) {
		String hql="DELETE FROM User WHERE uid in (" + uids + ")";
		getSession().createQuery(hql)
				.executeUpdate();
	}
	
	//管理员登录功能
	@Override
	public boolean validateUser(String user, String pass) {
		String hql="SELECT u FROM User u WHERE u.ulogin LIKE :ulogin";
		User user1=(User)getSession().createQuery(hql).setString("ulogin", user).uniqueResult();
		if((user1!=null)&&(user1.getUpassword().equals(pass))){
			System.out.println("登录成功");
			System.out.println("用户名："+user1.getUlogin());
			System.out.println("密码："+user1.getUpassword());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("nowuser", user1);
			User u=(User)session.getAttribute("nowuser");
			//更改当前用户状态为1（表示登录中）
			updateUsate(u.getUlogin(), 1);
			return true;
		}
		System.out.println("用户名或密码错误");
		return false;
		
	}
	
	//验证用户名是否已经存在
	@Override
	public boolean validateUserUlogin(String userUlogin){
		String hql="SELECT u FROM User u WHERE u.ulogin LIKE :ulogin";
		User user2=(User)getSession().createQuery(hql).setString("ulogin", userUlogin).uniqueResult();
		System.out.println("user2"+user2.getUlogin());
		if((user2!=null)&&user2.getUlogin().equals(userUlogin)){
			return true;
		}
		return false;
	}
	
	//修改密码时验证此用户名的原密码是否正确
	@Override
	public boolean validateUserUpass(String pass,String user){
		String hql="SELECT u FROM User u WHERE u.ulogin LIKE :ulogin";
		User user1=(User)getSession().createQuery(hql).setString("ulogin", user).uniqueResult();
		if((user1!=null)&&(user1.getUpassword().equals(pass))){
			System.out.println("密码验证成功");
			return true;
		}
		System.out.println("密码验证失败");
		return false;
	}

	//注销登录
	@Override
	public void logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("nowuser");
		//更改当前用户状态为0（表示未登录）
		updateUsate(user.getUlogin(), 0);
		//移除nowuser
		session.removeAttribute("nowuser");
	}

	//更改用户状态
	@Override
	public void updateUsate(String ulogin,int ustate) {
		String hql="UPDATE User u SET u.ustate=:ustate WHERE u.ulogin LIKE :ulogin";
		getSession().createQuery(hql).setString("ulogin", ulogin).setInteger("ustate", ustate).executeUpdate();
		System.out.println("更改当前用户："+ulogin+"的状态为："+ustate);
	}
	
	//将客房种类中的管理员设为空
	@Override
	public void setRoomcategoryRcuidNull(String rcuid) {
		String hql="FROM User u WHERE u.uid LIKE :rcuid";
		User user3=(User)getSession().createQuery(hql).setString("rcuid", rcuid).uniqueResult();
		if(user3!=null){
			String hql1="UPDATE Roomcategory r SET r.user=null WHERE r.user Like :user3";
			getSession().createQuery(hql1).setParameter("user3",user3).executeUpdate();
			System.out.println("将客房类型中id为："+rcuid+"的管理员设为空值");
	}
		
		
	}
	
}
