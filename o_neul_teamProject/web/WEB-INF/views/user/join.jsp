<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<div>${requestScope.msg}</div>
<form action="/user/join" method="post" id="join-frm" data-iuser="${sessionScope.loginUser.iuser}">
    <div><label>id : <input type="text" name="u_id" required></label></div>
    <div><span id="id-chk-msg"></span></div>
    <div><label>pw : <input type="password" name="u_pw" required></label></div>
    <div><span id="upw-chk-msg"></span></div>
    <div><label>pw-check : <input type="password" name="upw_chk" required></label></div>
    <div><span id="upwchk-chk-msg"></span></div>
    <div><label>name : <input type="text" name="u_nm" required></label></div>
    <div><span id="nm-chk-msg"></span></div>
    <span><label>e-mail : <input type="text" name="u_email" required></label></span> @
    <span><label><input type="text" name="addres" required></label></span>
    <select id="selEmail" onchange="checkemailaddy();">
        <option value="1">직접 입력</option>
        <option value="naver.com">naver.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="daum.net">daum.net</option>
        <option value="kakao.com">kakao.com</option>
        <option value="bing.com">bing.com</option>
    </select>
    <span><input type="button" value="이메일 중복 체크" id="email-btn-chk"><span id="email-chk-msg"></span></span>
    <div>
        <input type="submit" value="JOIN">
        <input type="reset" value="RESET">
    </div>
</form>
</div>


</body>
</html>
