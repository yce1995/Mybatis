package cn.easytop.lesson03.resultMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.easytop.lesson03.resultMap.xml.Grade;


public interface GradeMapper {
	/**
	 * ��ѯ���а༶
	 * @return
	 */
	public List<Grade> queryAllGrade();
	/**
	 * ͨ��ID ��ѯ���а༶
	 * @param gid
	 * @return
	 */
	//һ�Զ�
	@Results({
		@Result(property="gname1",column="gname"),
		@Result(property="studentList",column="gid",javaType=List.class,many=@Many(select="cn.easytop.lesson03.resultMap.anno.StudentMapper.queryStudentId"))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	//���һ
	@Results({
		@Result(property="gname1",column="gname")
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeId(String gif);
}
