package cn.easytop.lesson05.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestHelloWorld {

	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//���S�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	
	/**
	 * һ�����棺 ͬһ��session�������ͬһ�����ݵĲ�ѯ �����Ļ���
	 * ��һ�β�ѯ �������� ��ȡ����
	 * ͨ��session���õ�һ������
	 * �ڶ��β�ѯʱ ͨ��sessionһ�������ж��Ƿ���� ��ͬ����������ֵ ������� ֱ�ӷ������� ���� ��ѯ���ݿ�
	 * @throws IOException
	 */
	@Test
	public void testXmlInterface() throws IOException{
		SqlSession session =getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		//�ӻ����в�ѯ
		Student s1 = fm.queryStudentById("1");
		System.out.println(s==s1);
	}
	
	/**
	 * һ�����棺 ͬһ��session�������ͬһ�����ݵĲ�ѯ �����Ļ���
	 * ��һ�β�ѯ �������� ��ȡ����
	 * ͨ��session���õ�һ������
	 * �ڶ��β�ѯʱ ͨ��sessionһ�������ж��Ƿ���� ��ͬ����������ֵ ������� ֱ�ӷ������� ���� ��ѯ���ݿ�
	 * @throws IOException
	 */
	@Test
	public void testXmlInterface1() throws IOException{
		SqlSession session =getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		//�ӻ����в�ѯ
		Student s1 = fm.queryStudentById("1");
		System.out.println(s==s1);
	}
}
