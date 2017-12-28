package cn.easytop.lesson02.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.easytop.lesson02.annotion.Food;

public class TestHelloWorld {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson02/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	
	@Test
	public void textXmlInterface() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List list = fm.queryFood("�ཷ����","12");
		session.commit();
	}
	
	@Test
	public void textXmlInterface1() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List list = fm.queryFoodByFoodName("��");
		session.commit();
	}
	
	@Test
	public void saveXmlInterface2() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodName("������");
		food.setPricr("998");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId()+"--"+food.getFoodName()+"--"+food.getPricr());
	}
}
