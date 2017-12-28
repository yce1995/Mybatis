package cn.easytop.lesson03.resultMap.xml;

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
		String resource = "cn/easytop/lesson03/resultMap/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//π§≥ß¿‡
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	
	@Test
	public void textXmlInterface() throws IOException{
		SqlSession session=getSession();
		GradeMapper grade = session.getMapper(GradeMapper.class);
		List<Grade> list = grade.queryAllGrade();
		for(Grade a:list){
			System.out.println(a.getGid()+"---"+a.getGname1());
		}
	}
	
	@Test
	public void textManyToOne() throws IOException{
		SqlSession session=getSession();
		StudentMapper student = session.getMapper(StudentMapper.class);
		Student stu = student.queryStudent("2");
		System.out.println(stu.getSid()+"--"+stu.getSname()+"--"+stu.getGrade().getGname1());
	}
	
	@Test
	public void textOneToMant() throws IOException{
		SqlSession session=getSession();
		GradeMapper grade = session.getMapper(GradeMapper.class);
		Grade gra = grade.queryGrade("1");
		for(Student s:gra.getStudentList()){
			System.out.println(s.getSname());
		}
	}
}
