package com.gsbl.oneul.common;

import com.gsbl.oneul.commonModel.FoodDTO;
import com.gsbl.oneul.recofood.model.FoodConditionEntity;
import com.gsbl.oneul.recofood.model.FoodResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ajax/common")
public class CommonRestController {
    @Autowired
    private CommonService service;


    //술과 계절을 분기할수있는 restapi
    @GetMapping("/{subCode}")
    public List<FoodResultVO> getSeasonList(@PathVariable int subCode,@RequestParam int code, FoodConditionEntity entity){
        if(code==1){
            entity.setF_season(subCode);
        }else if(code==2){
            entity.setAlknum(subCode);
        }
        return service.getRdSeasonList(entity);
    }
}
