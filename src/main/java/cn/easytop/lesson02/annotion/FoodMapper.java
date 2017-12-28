package cn.easytop.lesson02.annotion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface FoodMapper {
	/**
	 * 根据名称 查询所有菜品
	 * 
	 * 
	 * @Select("select * from food where foodname =#{foodName} and price =#{price}")
	 * public List<Map> queryFood(@Param("foodName") String foodName,@Param("price") String price);
	 * 
	 */
	@Select("select * from food where foodname =#{0} and price =#{1}")
	public List<Map> queryFood(String foodName,String price);
	
	
	@Select("select * from food where foodname like '%${foodName}%'")
	public List<Food> queryFoodByFoodName(@Param("foodName") String foodName);
	
	/**
	 * 根据ID 删除
	 * @param foodId
	 * @return
	 */
	@Delete("delete from food where foodid=#{0}")
	public List deleteFood(String foodId);

	

	/**
	 * 插入food
	 * @param food
	 */
	@SelectKey(before=true,keyProperty="foodId",resultType=int.class, statement ="select FOOD_SEC.NEXTVAL from dual")
	@Insert("insert into food values(#{foodId},#{foodName},#{price})")
	public void saveFood(Food food);
}
