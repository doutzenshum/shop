package com.hungteshun.shop.user.service;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.hungteshun.shop.user.dao.UserDao;
import com.hungteshun.shop.user.vo.User;
import com.hungteshun.shop.utils.MailUtils;
import com.hungteshun.shop.utils.UUIDUtils;

/**
 * 用户模块的service层
 *
 */
@Transactional
public class UserService {

	//注入UserDao
	private UserDao userDao;

	public void setUserdao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询用户
	public User findByUsername(String username){
		
		return userDao.findByUsername(username);
	}

	//完善用户信息
	public void save(User user) {
		//保存用户信息到数据库
		user.setState(0);//0表示未激活，1表示已激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);

		StringBuilder page= new StringBuilder("<h1>欢迎来到线上商城，请点击下面的链接完成激活操作!</h1><h3><a href='http://www.doutzen.top/shop/user_active.action?code=");
		page.append(code.toString());
		page.append("'>点击");
		page.append("完成激活操作</a></h3>");

		MailUtils.send(user.getEmail(),page.toString(), "激活");
	}

	/**
	 * 根据激活码查询用户
	 * @param code
	 * @return 
	 */
	public boolean findByCode(String code) {
		User existUser = userDao.findByCode(code);
		boolean flag;
		if(existUser!=null){
			//用户存在，修改用户的状态，并且将用户的激活码删除
			existUser.setState(1);
			existUser.setCode(null);
			userDao.update(existUser);
			flag = true;
		}else{
			//用户不存在
			flag = false;
		}
		return flag;
	}

	/**
	 * 用户登录
	 * @param user
	 */
	public User login(User user) {
		return userDao.login(user);
	}
	
}
