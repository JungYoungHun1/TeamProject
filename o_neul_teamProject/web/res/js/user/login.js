
    const loginBtnElem = document.querySelector('#loginBtn');

    if (loginBtnElem.dataset.iuser) {
        location.href = "/main";
    }

    if (loginBtnElem) {
        if (loginBtnElem.dataset.msg != 0) {
            alert(loginBtnElem.dataset.msg);
        }
    }
    // --------네이버----------
    var naver_id_login = new naver_id_login("CU4oIqnKlO1XPT8Z1wwf", "http://localhost:8090/naver/ncallback");
    var state = naver_id_login.getUniqState();
    naver_id_login.setButton("green", 2,50);
    naver_id_login.setDomain("YOUR_SERVICE_URL");
    naver_id_login.setState(state);
    naver_id_login.setPopup();
    naver_id_login.init_naver_id_login();

    // --------카카오----------

    Kakao.init('a240cd5b5321fd46f13d6809dfd9b250'); //발급받은 키 중 javascript키를 사용해준다.
    console.log(Kakao.isInitialized()); // sdk초기화여부판단

    function kakaoLogin() {
        Kakao.Auth.login({
            success: function (response) {
                Kakao.API.request({
                    url: '/v2/user/me',
                    success: function (response) {
                        console.log(response);
                        var email = response.kakao_account.email;
                        var nickname = response.kakao_account.profile.nickname;
                        const loginObj= {
                            u_email: email,
                            u_nm: nickname
                        }
                        var url = "/user/kakao"
                        fetch(url, {
                            method: 'post',
                            headers: { 'Content-Type': 'application/json' },
                            body: JSON.stringify(loginObj)
                        }).then(function(res) {
                            location.href='/main';
                            return res.json();
                        }).then(function(data) {
                            console.log(data);
                        }).catch(function (err) {
                            console.log(err);
                        });
                    },
                    fail: function (error) {
                        console.log(error)
                    },
                })
            },
            fail: function (error) {
                console.log(error)
            },
        })
    }

// --------구글----------

    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        const name = profile.getName();
        const email = profile.getEmail();
        const loginObj = {
            u_email:email,
            u_nm:name
        };
        var url = "/user/google";
        fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(loginObj)
        }).then(function(res) {
            location.href='/main';
            return res.json();
        }).then(function(data) {
            console.log(data);
        }).catch(function (err) {
            console.log(err);
        });
    }



