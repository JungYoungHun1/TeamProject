package com.gsbl.oneul.common;

import com.gsbl.oneul.commonModel.FoodDTO;
import com.gsbl.oneul.recofood.model.FoodResultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonMapper {

    List<FoodResultVO> selSeasonList(FoodDTO dto);
}
