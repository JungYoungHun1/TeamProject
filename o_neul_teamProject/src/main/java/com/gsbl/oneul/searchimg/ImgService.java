package com.gsbl.oneul.searchimg;

import com.gsbl.oneul.searchimg.model.SearchImgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgService {
    @Autowired
    private MySerachImgApiUtils imgApiUtils;

    public List<SearchImgVO> getImg(String search){
        List<SearchImgVO> list = imgApiUtils.searchPlace(search);
        return list;
    }
}
