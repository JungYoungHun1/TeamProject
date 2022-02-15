package com.gsbl.oneul.searchimg;

import com.gsbl.oneul.searchimg.model.SearchImgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/img/search")
public class ImgController {
    @Autowired
    private ImgService service;

    @GetMapping
    public Map<String,List<SearchImgVO>> getImg(@RequestParam String search){
        List<SearchImgVO> list = service.getImg(search);
        Map<String,List<SearchImgVO>> map = new HashMap<>();
        map.put("result",list);
        return map;
    }
}
