package cn.it.hotel.service;

import java.util.List;

import cn.it.hotel.model.Roomcategory;
import cn.it.hotel.model.User;

public interface UserService extends BaseService<User> {

	    //查询用户信息，分页
		public List<User> queryUser(String uname,int page,int size);
		//根据关键字查询总记录数
		public Long getCount(String uname);
		//根据ids删除多条记录
		public void deleteByUids(String uids);
		//验证用户名和密码
		public boolean validateUser(String user,String pass);
		//更改用户状态
		public void updateUsate(String ulogin,int ustate);
		//将客房种类中的管理员设为空
		public void setRoomcategoryRcuidNull(String rcuid);
		//注销用户
		public void logout();
		//验证用户名是否已经存在
		public boolean validateUserUlogin(String userUlogin);
		//修改密码时验证此用户名的原密码是否正确
		public boolean validateUserUpass(String userUpass,String userUlogin);
}
