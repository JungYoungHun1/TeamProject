<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name='common'/>.css">
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name='addr1'/>/index.css">
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name='addr2'/>.css">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
    <script defer src="/res/js/map.js"></script>
    <script defer src="/res/js/<tiles:getAsString name='common'/>.js"></script>
    <script defer src="/res/js/<tiles:getAsString name='addr1'/>/index.js"></script>
    <script defer src="/res/js/<tiles:getAsString name='addr2'/>.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=25634032cad38fd0169f02c62df4da24&libraries=services,clusterer,drawing"></script>

    <title></title>
</head>
<body>
<!--현재 주소창의 주소값을 가져오는것-->
<c:set var="currentPagePath" value="${requestScope['javax.servlet.forward.request_uri']}" />
    <div>
        <tiles:insertAttribute name="header"/>
        <section class="content-container">
            <tiles:insertAttribute name="content"/>
        </section>
        <tiles:insertAttribute name="footer"/>
    </div>
    <input type="hidden" id="errMsg" value="${requestScope.err}">
</body>
</html>