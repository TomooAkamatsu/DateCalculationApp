package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CalcResult;
import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;

@Service
public class DateCalcService {

	@Autowired
	DateCalcMapper dateCalcMapper;

	public List<Pattern> getPattern(){
		List<Pattern> dateCalcList = dateCalcMapper.findAll();
		return dateCalcList;
	}

//	計算基準となる日付を表示する用の変数
	public String standartDate;
	
//	結果表示用のListを宣言
	public List<CalcResult> calcResultList = new ArrayList<>();

	public void calcDate(String strDate) {
//		Listを初期化
		calcResultList.clear();
		
//		'-'から'/'に置換して変数に代入
		standartDate = strDate.replace('-','/');
		
//		日付をString型からLocalDate型へ変換
		LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//		計算パターンを取得
		List<Pattern> patterns = dateCalcMapper.findAll();

//		取得した計算パターンを元に順に計算を行いListにつめる
		for (Pattern pattern : patterns) {
			
//			日付の計算を行う
			LocalDate dateCalculated = date.plusYears(pattern.getCalcY()).plusMonths(pattern.getCalcM()).plusDays(pattern.getCalcD());

//			計算結果をLocalDate型からString型へ
			String strDateCalculated = dateCalculated.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

//			計算結果を含めた引数を渡して結果表示用のインスタンスを作成
			CalcResult calcResult = new CalcResult(
					pattern.getNumber(),
					pattern.getDateId(),
					pattern.getDateName(),
					strDateCalculated,
					pattern.getCalcY() + "/" + pattern.getCalcM() + "/" + pattern.getCalcD()
					);
//			作成したインスタンスをListに追加
			calcResultList.add(calcResult);
		}
	}
	
}
