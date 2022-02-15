<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="my" uri="tld/MyCustomJstlTag.tld" %>

<link rel="shortcut icon" href="#">
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<meta name="google-signin-client_id" content="808354205537-osu6jfd5peaqbqnmuhp3dctkn1mfhanb.apps.googleusercontent.com">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"><header class="bg-pink hg-100">
    <section class="header-logo ">
        <div class="mr50">
            <a href="/main"><img class="sizeLogo" src="/res/img/logo_white.png"></a>
        </div>
        <div class="flex-c-r g30">
            <div><a href="/food/random">오늘의 음식</a></div>
            <div><a href="#">오늘의 맛집</a></div>
            <div><a href="#">방송별 맛집</a></div>
            <div><a href="#">계절별 음식</a></div>
            <div><a href="#">술과 페어링</a></div>
        </div>
    </section>
    <section class="header-user g50">
        <div class="search-box">
            <button class="search-btn"><i class="fas fa-search"></i></button>
            <input type="text" placeholder="맛집이름을 검색해주세요!">
        </div>
        <c:choose>
            <c:when test="${sessionScope.loginUser!=null}">
                <span><my:profileImg classVal="circular--img wh-30" iuser="${sessionScope.loginUser.iuser}"
                                                                                  imgIdVal="header-profileimg"
                                                                                  profileImgVal="${sessionScope.loginUser.u_profileimg}"/></span>
                <c:if test="${sessionScope.loginUser.u_nickname != null}">
                    <a class="flex-c-r">${sessionScope.loginUser.u_nickname}님</a>
                </c:if>
                <c:if test="${sessionScope.loginUser.u_nickname == null}">
                    <a class="flex-c-r">${sessionScope.loginUser.u_nm}님</a>
                </c:if>
                <span class="flex-c-r"><a href="/user/mypage/profile">마이페이지</a></span>
                <c:if test="${sessionScope.loginUser.u_pfnum == 1}">
                <a href="/user/logout" class="flex-c-r">로그아웃</a>
                </c:if>
                <c:if test="${sessionScope.loginUser.u_pfnum == 2}">
                    <span onclick="naverLogout(); return false;" class="flex-c-r">
                        <a href="javascript:void(0)">
                            <span>네이버 로그아웃</span>
                        </a>
                    </span>
                </c:if>
                <c:if test="${sessionScope.loginUser.u_pfnum == 3}">
                    <span onclick="kakaoLogout();" class="flex-c-r">
                        <a href="javascript:void(0)">
                            <span>카카오 로그아웃</span></a>
                    </span>
                </c:if>
                <c:if test="${sessionScope.loginUser.u_pfnum == 4}">
                    <input type="hidden" class="g-signin2" data-onsuccess="onSignIn"></input>
                    <span class="flex-c-r"><a href="#" onclick="signOut();">구글 로그아웃</a></span>
                </c:if>
            </c:when>
            <c:otherwise>
                <a href="/user/login" class="flex-c-r">로그인</a>
                <a href="/user/join" class="flex-c-r">회원가입</a>
            </c:otherwise>
        </c:choose>
    </section>
</header>
