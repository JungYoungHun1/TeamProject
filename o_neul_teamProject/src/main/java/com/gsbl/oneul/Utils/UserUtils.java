package com.gsbl.oneul.Utils;

import com.gsbl.oneul.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class UserUtils {
    @Autowired
    private HttpSession hs;

    public void setLoginUser(UserVO vo){
        hs.setAttribute(Const.LOGIN_USER, vo);
    }
    public UserVO getLoginUser(){
        return (UserVO) hs.getAttribute(Const.LOGIN_USER);
    }
    public int getLoginUserPk(){
        return getLoginUser() == null ? 0 : getLoginUser().getIuser();
    }
}
