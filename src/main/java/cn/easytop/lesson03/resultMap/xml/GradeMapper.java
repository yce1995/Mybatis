package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


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
	public Grade queryGrade(String gid);
}
