package com.gsbl.oneul.common;

import com.gsbl.oneul.commonModel.FoodDTO;
import com.gsbl.oneul.recofood.RecoFoodMapper;
import com.gsbl.oneul.recofood.model.FoodConditionEntity;
import com.gsbl.oneul.recofood.model.FoodResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService {
    @Autowired
    private CommonMapper mapper;
    @Autowired
    private RecoFoodMapper recoFoodMapper;

    public List<FoodResultVO> getRdSeasonList(FoodConditionEntity entity){
        List<FoodResultVO> list = recoFoodMapper.selFoodList(entity);
        List<FoodResultVO> resultList = new ArrayList<>();
        for(int i=0;i<4;i++){
            int rdNum = (int)(Math.random()*list.size());
            resultList.add(list.remove(rdNum));
        }
        return resultList;
    }
}
