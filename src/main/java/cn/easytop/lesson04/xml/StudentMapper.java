package cn.easytop.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

	/**
	 * ͨ����Ų�ѯѧ��
	 * @param sid
	 * @return
	 */
	public List<Student> queryStudent(Student student);
	/**
	 * �����Ա���������ѧ��
	 * ������ ����sex �͸���������  û�д�ֵ  ������Ů��
	 * @param sex
	 * @return
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * ����ѧ����Ϣ
	 * @param sid
	 * @return
	 */
	public void updateStudent(Student student);
	/**
	 * ͨ������İ༶��ѯ����ѧ��
	 * 0,1,2
	 * 1,2
	 * 2,3,4
	 * 
	 * @param gradeList
	 */
	public List<Student> queryStudentbyAnyGrade(@Param("gradeList")List<String> gradeList);
	
	
}
