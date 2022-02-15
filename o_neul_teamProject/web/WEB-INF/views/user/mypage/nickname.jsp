<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h1>닉네임 변경</h1>
    <div class="msg">${requestScope.err}</div>
    <form action="/user/mypage/nickname" method="post" id="join-frm" data-iuser="${sessionScope.loginUser.iuser}">
        <div><label>변경 닉네임 : <input type="text" name="u_nickname" required></label></div>
        <div><span id="nickname-chk-msg"></span></div>
        <div><input type="submit" value="변경" id="submitBtn"></div>
    </form>
</div>
