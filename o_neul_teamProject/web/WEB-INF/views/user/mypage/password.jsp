<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h1>비밀번호 변경</h1>
    <div>${requestScope.msg}</div>
    <form action="/user/mypage/password" method="post" id="change" data-iuser="${sessionScope.loginUser.iuser}"
          data-msg="${requestScope.msg}">
        <div><label>현재 비밀번호 : <input type="password" name="currentupw" required></label></div>
        <div><span id="current-chk-msg"></span></div>
        <div><label>변경 비밀번호 : <input type="password" name="u_pw" required></label></div>
        <div><span id="upw-chk-msg"></span></div>
        <div><label>확인 비밀번호 : <input type="password" name="chkupw" required></label></div>
        <div><span id="upwchk-chk-msg"></span></div>
        <div><input type="submit" value="변경" id="submitBtn"></div>
    </form>
</div>
