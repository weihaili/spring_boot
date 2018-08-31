package org.cn.kkl.sb.config;

import org.cn.kkl.sb.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(basePackages="org.cn.kkl.sb.service")
@PropertySource(value={"classpath:db/mysql.properties","classpath:db/redis.properties"},ignoreResourceNotFound=true)
public class DaoConfig {
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String pwd;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driverClass}")
	private String driverClass;
	
	
	@Bean
	public UserDao getUserDao(){
		return new UserDao();
	}
	
	/**
	 * @return
	 * method name equivalent to spring bean id
	 */
	@Bean(destroyMethod="close")
	public BoneCPDataSource boneCPDataSource(){
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);//driver class
		dataSource.setUsername(username);//username
		dataSource.setPassword(pwd);//password
		dataSource.setJdbcUrl(url);//url
		dataSource.setIdleConnectionTestPeriodInMinutes(60);
		dataSource.setIdleMaxAgeInMinutes(30);
		dataSource.setMaxConnectionsPerPartition(100);
		dataSource.setMinConnectionsPerPartition(5);
		return dataSource;
	}

}
