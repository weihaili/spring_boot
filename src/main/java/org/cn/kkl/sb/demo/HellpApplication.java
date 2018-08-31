package org.cn.kkl.sb.demo;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude={LiquibaseAutoConfiguration.class})
@Configuration
public class HellpApplication {
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello(){
		return "Hello world 中国";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HellpApplication.class);
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		return new StringHttpMessageConverter(Charset.forName("UTF-8")); 
	}

}
