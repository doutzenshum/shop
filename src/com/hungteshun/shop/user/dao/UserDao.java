package com.hungteshun.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hungteshun.shop.user.vo.User;

/**
 * 用户模块持久层代码
 * @author hungteshun黄调聪
 * 继承HibernateDaoSupport，会为我们提供一个hibernate模板，
 * 我们需要将sessionFactory注入到Dao中，就可以使用hibernate模板
 */
public class UserDao extends HibernateDaoSupport{

	//按名称查询是否存在用户
	public User findByUsername(String username){
		String hql = "from User where username = ?";
		List<User> userLists = this.getHibernateTemplate().find(hql, username);
		if(userLists != null && userLists.size() > 0){
			return userLists.get(0);
		}else {
			return null;
		}
	}
	//保存用户信息到数据库
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
}
