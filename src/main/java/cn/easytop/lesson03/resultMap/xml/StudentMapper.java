package cn.easytop.lesson03.resultMap.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


public interface StudentMapper {
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param sid
	 * @return
	 */
	public Student queryStudent(String sid);

}
