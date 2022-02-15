<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="tld/MyCustomJstlTag.tld" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<h1>프로필</h1>
<div id="data" data-iuser="${sessionScope.loginUser.iuser}"></div>
<div class="flex-container flex-direction-column flex-align-center">
    <my:profileImg idVal="profile-view"
                   classVal="pointer circular--img wh-300"
                   iuser="${sessionScope.loginUser.iuser}"
                   profileImgVal="${sessionScope.loginUser.u_profileimg}"/>

    <input type="file" id="profile-file" class="hidden" accept="image/*">
    <div>아이디 : ${sessionScope.loginUser.u_id}</div>
    <div>이름 : ${sessionScope.loginUser.u_nm}</div>
    <c:if test="${sessionScope.loginUser.u_pfnum == 1}">
        <div><a href="/user/mypage/password">비밀번호 변경</a></div>
    </c:if>
    <c:if test="${sessionScope.loginUser.u_nickname == null}">
        <div>닉네임을 설정해주세요</div>
    </c:if>
    <c:if test="${sessionScope.loginUser.u_nickname != null}">
        <div>닉네임 : ${sessionScope.loginUser.u_nickname}</div>
    </c:if>
    <div><a href="/user/mypage/nickname">닉네임 설정</a></div>
</div>
</body>
</html>
