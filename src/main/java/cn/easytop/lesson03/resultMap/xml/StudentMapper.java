package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


public interface StudentMapper {
	/**
	 * 通过编号查询学生
	 * @param sid
	 * @return
	 */
	public Student queryStudent(String sid);

}
