package com.gsbl.oneul.Utils;

import com.gsbl.oneul.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static UserVO getLoginUser(HttpServletRequest req) {
        HttpSession hs = req.getSession();
        return (UserVO) hs.getAttribute("loginUser");
    }

    public static int getLoginUserPk(HttpServletRequest req) {
        UserVO loginUser = getLoginUser(req);
        if(loginUser == null) { return 0; }
        return loginUser.getIuser();
    }

    public static String getJson(HttpServletRequest request) throws IOException {
        String reqStr = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        reqStr = stringBuilder.toString();
        return reqStr;
    }
}
