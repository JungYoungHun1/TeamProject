package com.gsbl.oneul.recofood;

import com.gsbl.oneul.common.CommonMapper;
import com.gsbl.oneul.recofood.model.FoodConditionEntity;
import com.gsbl.oneul.recofood.model.FoodResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoFoodService {
    @Autowired
    private RecoFoodMapper recoFoodMapper;
    @Autowired
    private CommonMapper commonMapper;

    //검색조건 넣고 결과 리스트로 가져오기
    public FoodResultVO getList(FoodConditionEntity entity){
        List<FoodResultVO> list = recoFoodMapper.selFoodList(entity);
        //랜덤으로 하나 추출
        if(list.size()==0){
            return null;
        }
        FoodResultVO vo = list.get((int)(Math.random()* list.size()));
        return vo;
    }
}
