package cn.easytop.lesson04.anno;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import cn.easytop.lesson04.xml.Student;


public interface StudentMapper {

	static class StudentProvier{
		/**
		 * ${}��ע����� ʧЧ
		 * ��������� ȡֵ ����.������
		 * �ṩsql�����Ĳ��� �� Map ��ֵ��
		 * �ṩsql��䷽��
		 * @param map
		 * @return
		 */
		public String queryStudentSql(Map map){
			Student student=(Student)map.get("stu");
			String sql=" select * from student where 1=1 ";
			if(student.getSname()!=null &&!"".equals(student.getSname())){
				student.setSname("%"+student.getSname()+"%");
				sql+=" and sname like #{stu.sname}";
			}
			if(student.getAddress()!=null &&!"".equals(student.getAddress())){
				student.setAddress("%"+student.getAddress()+"%");
				sql+="  and address like #{stu.address} ";
			}
			return sql;
		}
		
		
		public String queryStudentSql1(Map map){
			Student student=(Student)map.get("stu");
			SQL sql=new SQL();
			sql.SELECT("*").FROM("student");
			if(student.getSname()!=null &&!"".equals(student.getSname())){
				student.setSname("%"+student.getSname()+"%");
				sql.WHERE(" sname like #{stu.sname}");
			}
			if(student.getAddress()!=null &&!"".equals(student.getAddress())){
				student.setAddress("%"+student.getAddress()+"%");
				sql.AND();
				sql.WHERE(" address like #{stu.address}");
			}
			return sql.toString();
		}
	}
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param sid
	 * @return
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentSql1")
	public List<Student> queryStudent(@Param("stu")Student student);
	/**
	 * �����Ա���������ѧ��
	 * ������ ����sex �͸���������  û�д�ֵ  ������Ů��
	 * @param sex
	 * @return
	 */
	@Select("<script>select * from student where 1=1 " +
			"<choose>"+
      	"<when test=\"sex!=null\">"+
      	 "   and sex=#{sex}"+
      	"</when>"+
      	" <otherwise>"+
      	"   and sex=1 "+
      	"</otherwise>"+
      "</choose></script>")
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
