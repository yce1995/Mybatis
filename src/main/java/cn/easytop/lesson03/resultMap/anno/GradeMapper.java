package cn.easytop.lesson03.resultMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.easytop.lesson03.resultMap.xml.Grade;


public interface GradeMapper {
	/**
	 * 查询所有班级
	 * @return
	 */
	public List<Grade> queryAllGrade();
	/**
	 * 通过ID 查询所有班级
	 * @param gid
	 * @return
	 */
	//一对多
	@Results({
		@Result(property="gname1",column="gname"),
		@Result(property="studentList",column="gid",javaType=List.class,many=@Many(select="cn.easytop.lesson03.resultMap.anno.StudentMapper.queryStudentId"))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	//多对一
	@Results({
		@Result(property="gname1",column="gname")
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeId(String gif);
}
