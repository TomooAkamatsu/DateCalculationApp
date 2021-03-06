package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.domain.Pattern;

@Mapper
public interface DateCalcMapper {

//	全件取得
	public List<Pattern> findAll();

//	新規登録
	public void addCalcPattern(Pattern pattern);

//	削除
	public void deleteCalcPattern(int id);

//	更新
	public void updateCalcPattern(Pattern pattern);

}
