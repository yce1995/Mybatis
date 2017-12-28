package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


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
	public Grade queryGrade(String gid);
}
