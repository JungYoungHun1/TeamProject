package com.gsbl.oneul.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/map",produces ="application/text; charset=utf8")
public class MapRestControllor {
    @Autowired
    private MapService mapService;

    //카카오map에서 가져온 or 데이터베이스에서 가져온 ijmt(id)를 넣으면 json을 보내줌
    @GetMapping("/{ijmt}")
    public String  getKakaoPlace(@PathVariable int ijmt, HttpServletRequest rq) throws UnsupportedEncodingException {
        rq.setCharacterEncoding("UTF-8");
        return mapService.kakaoJsonPage(ijmt);
    }
}
