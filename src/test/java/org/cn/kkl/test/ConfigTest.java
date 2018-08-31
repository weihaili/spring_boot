package org.cn.kkl.test;

import java.util.List;

import org.cn.kkl.sb.config.DaoConfig;
import org.cn.kkl.sb.entity.User;
import org.cn.kkl.sb.service.IUserBiz;
import org.cn.kkl.sb.service.impl.UserBiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

	private AnnotationConfigApplicationContext context;
	
	IUserBiz userBiz;

	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		userBiz = context.getBean(UserBiz.class);
	}
	
	@Test
	public void testGetUserList(){
		List<User> users = userBiz.queryUserList();
		for (User user : users) {
			System.out.println("username: "+user.getUsername()+",pwd "+user.getPassword());
		}
	}
	
	@Test
	public void testProperties(){
		Object bean = context.getBean("boneCPDataSource");
		System.out.println(bean);
	}
	
	@After
	public void destory(){
		if (context!=null) {
			context.destroy();
		}
	}
}
