<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=25634032cad38fd0169f02c62df4da24&libraries=services,clusterer,drawing"></script>
</head>
<body>
    <div class="flex-c-c">
        <img class="random-food-banner" src="/res/img/con1.png">
    </div>
    <div class="random-food-container flex-c-c">
        <section class="random-food-condition">
            <i class="fas fa-random f-s-40 flex-c-c cc"></i>
            <div class="line">검색 조건</div>
            <div class="flex-c-c">제거하고 싶은 항목을 클릭하세요!</div>
            <div class="fc-box flex-c-c mt40 mb100" id="fcf_box">
                <form id="foodCheckFrm" class="flex-c-c" method="post">
                    <div>
                        <fieldset class="flex-c-c">
                            <div class="fsfw mb20">조리방법</div>
                            <fieldset class="w100 flex-c-r g30 border-rd mb50">
                                <label>구이류<input type="checkbox" name="f_cookery" value="1"></label>
                                <label>국류<input type="checkbox" name="f_cookery" value="2"></label>
                                <label>면류<input type="checkbox" name="f_cookery" value="3"></label>
                                <label>무침류<input type="checkbox" name="f_cookery" value="4"></label>
                                <label>밥류<input type="checkbox" name="f_cookery" value="5"></label>
                                <label>볶음류<input type="checkbox" name="f_cookery" value="6"></label>
                                <label>전류<input type="checkbox" name="f_cookery" value="7"></label>
                                <label>조림류<input type="checkbox" name="f_cookery" value="8"></label>
                                <label>죽류<input type="checkbox" name="f_cookery" value="9"></label>
                                <label>찌개류<input type="checkbox" name="f_cookery" value="10"></label>
                                <label>찜류<input type="checkbox" name="f_cookery" value="11"></label>
                                <label>탕류<input type="checkbox" name="f_cookery" value="12"></label>
                                <label>튀김류<input type="checkbox" name="f_cookery" value="13"></label>
                                <label>빵류<input type="checkbox" name="f_cookery" value="14"></label>
                            </fieldset>
                            <div class="w100 confm-grid">
                                <div class="confm-item">
                                    <div class="fsfw mb20">나라별</div>
                                    <fieldset class="flex-c-r g30 border-rd mb20">
                                        <label>한식<input type="checkbox" name="f_worlddiv" value="1"></label>
                                        <label>양식<input type="checkbox" name="f_worlddiv" value="2"></label>
                                        <label>일식<input type="checkbox" name="f_worlddiv" value="3"></label>
                                        <label>중식<input type="checkbox" name="f_worlddiv" value="4"></label>
                                    </fieldset>
                                </div>
                                <div class="confm-item">
                                    <div class="fsfw mb20">재료별</div>
                                    <fieldset class="flex-c-r g30 border-rd mb20">
                                        <label>육류<input type="checkbox" name="igd" value="1"></label>
                                        <label>해산물<input type="checkbox" name="igd" value="2"></label>
                                        <label>채소<input type="checkbox" name="igd" value="3"></label>
                                        <label>가공품<input type="checkbox" name="igd" value="4"></label>
                                    </fieldset>
                                </div>
                                <div class="confm-item">
                                    <div class="fsfw mb20">인원수</div>
                                    <fieldset class="flex-c-r g30 border-rd mb20">
                                        <label class="chk-o">상관없음<input  type="radio" name="alone" value="0" checked></label>
                                        <label>1인분<input type="radio" name="alone" value="1"></label>
                                    </fieldset>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="flex-c-r g100 mt60">
                        <div id="btn_reset" class="con-btn-box pointer flex-c-r">
                            <img  class="wh-btn" src="/res/img/con_re.png">
                            <div class="fsfw15">리셋</div>
                        </div>
                        <div id="btn_search" class="con-btn-box pointer flex-c-r">
                            <img class="wh-btn" src="/res/img/con_go_b.png">
                            <div class="fsfw15">검색</div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="line"><i id="food_light" class="far fa-lightbulb"></i></div>
        </section>
        <section id="s_food_img" class="random-food-img-info mt40">
            <div class="flex-c-c">
                <div class="food-result-nm" id="foodInfo"></div>
            </div>
            <div class="flex-c-c">
                <div id="foodImg" class="flex-c-c food-img-box"></div>
            </div>
        </section>
        <section id="s_food_map" class="random-food-map">
            <div class="line"><i id="showmap_btn" class="f-s-40 fas fa-map-marked-alt"></i></div>
            <div id="map_title" class="flex-c-r mt20"></div>
            <div class="map-restbox flex-c-c g30 mt60">
                <div id="map" style="width:1500px;height:400px;"></div>
                <div id="restaurant_box" class="restbox"></div>
            </div>
        </section>
    </div>
</body>
<div class="food-caution">주의 : 음식에 해당하는 조건들 중 일부분은
    team-gsvn의 주관적인 의견이 담겨있으며, 이미지들은 naver의 이미지 검색 api를 통해 가져오는 것 이고,
    내주변 식당은 kakao 장소검색 api를 활용해 근방 5km를 탐색한다</div>
</html>