package com.newcoder.community;

import com.newcoder.community.config.AlphaConfig;
import com.newcoder.community.controller.AlphaController;
import com.newcoder.community.dao.AlphaDao;
import com.newcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //以CommunityApplication为配置类启动
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext; //Spring 容器

	//哪个类想要获得容器，就实现 ApplicationContextAware 方法， 然后 重写 setApplicationContext 方法
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;  //获取了 Spring容器
	}
	//application是spring容器，可以用于获取bean
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		AlphaController alphaController = applicationContext.getBean(AlphaController.class);
		System.out.println(alphaController);
	}
	@Test
	//当一个接口有两个实现类的时候，可以指定bean的名字获取bean
	public void testGetSpecifiedBeanImpl(){
		AlphaDao alphaDao = applicationContext.getBean("alphaDaoHibernateImpl",AlphaDao.class);
		System.out.println(alphaDao.select());
	}
	//测试Spring容器启动管理bean的过程
	@Test
	public void testBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		System.out.println("test process");
	}
	//测试一下Spring容器配置第三方bean的过程
	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired //自动装配Bean
	@Qualifier("alphaDaoHibernateImpl") //指定使用哪个bean
	private AlphaDao alphaDao;
	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}
}
