package cn.easytop.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


public interface FoodMapper {
	/**
	 * �������� ��ѯ���в�Ʒ
	 */
	public List queryFood(String foodName,String price);
	
	
	public List queryFoodByFoodName(@Param("foodName")String foodName);
	/**
	 * ����ID ɾ��
	 * @param foodId
	 * @return
	 */
	public List deleteFood(String foodId);
	
	/**
	 * ����food
	 * @param food
	 */
	public void saveFood(Food food);
}
