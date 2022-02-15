package com.gsbl.oneul.recofood;

import com.gsbl.oneul.recofood.model.FoodConditionEntity;
import com.gsbl.oneul.recofood.model.FoodResultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecoFoodMapper {
    //조건을 넣어서 리스트를 뽑아보자
    List<FoodResultVO> selFoodList(FoodConditionEntity entity);
}
