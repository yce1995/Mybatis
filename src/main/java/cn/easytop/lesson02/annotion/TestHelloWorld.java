package cn.easytop.lesson02.annotion;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.easytop.lesson02.annotion.FoodMapper;

public class TestHelloWorld {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson02/annotion/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	
	@Test
	public void textAnnoInterface() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Food> list = fm.queryFoodByFoodName("蛋");
		System.out.println(list);
	}
	
	@Test
	public void saveAnnoInterface2() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodName("大保健");
		food.setPricr("998");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId()+"--"+food.getFoodName()+"--"+food.getPricr());
	}
}
