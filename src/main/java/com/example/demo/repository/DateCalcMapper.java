package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Pattern;

@Mapper
public interface DateCalcMapper {
	
	@Select("SELECT * FROM calc_pattern")
	public List<Pattern> findAll();
	
	@Insert("INSERT INTO calc_pattern(date_id, date_name, calc_y, calc_m, calc_d) "
			+ "VALUES(#{dateId}, #{dateName}, #{calcY}, #{calcM}, #{calcD});")
	public void addPattern(Pattern pattern);
	
	@Delete("DELETE FROM calc_pattern WHERE number = #{number}")
	public void deletePattern(int number);
	
	@Update("UPDATE calc_pattern SET date_id = #{dateId}, "
			+ "date_name = #{dateName}, "
			+ "calc_y = #{calcY}, calc_m = #{calcM}, "
			+ "calc_d = #{calcD} "
			+ "WHERE number = #{number};")
	public void updatePattern(Pattern pattern);

}
