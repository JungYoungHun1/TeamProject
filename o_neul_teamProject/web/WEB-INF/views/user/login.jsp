<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="shortcut icon" href="#">
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
            charset="utf-8"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <meta name="google-signin-client_id"
          content="808354205537-osu6jfd5peaqbqnmuhp3dctkn1mfhanb.apps.googleusercontent.com">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form id="loginBtn" action="/user/login" method="post" data-msg="${requestScope.msg}"
          data-iuser="${sessionScope.loginUser.iuser}">
        <div><input type="text" name="u_id" placeholder="아이디" value="ju39001"></div>
        <div><input type="password" name="u_pw" placeholder="비밀번호" value="ju@13657213"></div>
        <div><input type="submit" value="로그인"></div>
    </form>
    <span><a href="/user/join"><input type="button" value="회원가입"></a></span>

    <%--네이버--%>
    <div id="naver_id_login" >
        <a id="naverIdLogin_loginButton">
            <img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0" width="50%" height="auto" style="max-width:100px;max-height:60px"/>
        </a>
    </div>

    <%--카카오--%>
    <span onclick="kakaoLogin();">
        <a href="javascript:void(0)">
            <img src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="80%" height="45px"
                 style="max-width:130px;max-height:80px" alt="카카오 로그인 버튼"/>
        </a>
    </span>

    <%-- 구글--%>
    <div class="g-signin2" data-onsuccess="onSignIn" style="width: 130px" onclick="onSignIn()"></div>

</body>
</html>