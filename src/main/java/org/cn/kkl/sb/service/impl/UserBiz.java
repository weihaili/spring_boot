package org.cn.kkl.sb.service.impl;

import java.util.List;

import org.cn.kkl.sb.dao.UserDao;
import org.cn.kkl.sb.entity.User;
import org.cn.kkl.sb.service.IUserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz implements IUserBiz{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> queryUserList() {
		
		return userDao.queryUserList();
	}

}
