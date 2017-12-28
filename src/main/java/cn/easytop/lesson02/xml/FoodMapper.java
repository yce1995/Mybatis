package cn.easytop.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easytop.lesson02.annotion.Food;


public interface FoodMapper {
	/**
	 * 根据名称 查询所有菜品
	 */
	public List queryFood(String foodName,String price);
	
	
	public List queryFoodByFoodName(@Param("foodName")String foodName);
	/**
	 * 根据ID 删除
	 * @param foodId
	 * @return
	 */
	public List deleteFood(String foodId);
	
	/**
	 * 插入food
	 * @param food
	 */
	public void saveFood(Food food);
}
