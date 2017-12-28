package cn.easytop.lesson03.resultMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.easytop.lesson03.resultMap.xml.Student;


public interface StudentMapper {
	/**
	 * 通过编号查询学生
	 * @param sid
	 * @return
	 */
	
	//多对一
	@Results({
		@Result(property="grade",column="gid",one=@One(select="cn.easytop.lesson03.resultMap.anno.GradeMapper.queryGradeId"))
		
	})
	@Select("select * from student where sid=#{0}")
	public Student queryStudent(String sid);
	
	
	//一对多
	@Select("select * from student where gid=#{0}")
	public List<Student> queryStudentId(String gid);
}
