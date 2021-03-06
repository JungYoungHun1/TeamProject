{
    let nicknameChkState = 2;
    const joinFrmElem = document.querySelector('#join-frm');
    if(!joinFrmElem.dataset.iuser){
        location.href="/user/login";
    }
    const nicknameRegex = /^([a-zA-Z0-9가-힣]{2,6})$/;




    const setnicknameChkMsg = (data) => {
        nicknameChkState = data.nickname; //0 or 1

        const nicknameChkMsgElem = joinFrmElem.querySelector('#nickname-chk-msg');
        switch (data.nickname) {
            case 0:
                nicknameChkMsgElem.innerText = '이미 사용중인 닉네임 입니다.';
                break;
            case 1:
                nicknameChkMsgElem.innerText = '사용할 수 있는 닉네임 입니다.';
                break;
        }
    };

    if (joinFrmElem) {
        joinFrmElem.addEventListener('submit', (e) => {
            const nickname = joinFrmElem.u_nickname.value;
            if(!nicknameRegex.test(nickname)){
                alert('닉네임은 대소문자, 숫자, 한글 조합으로 2~6글자가 되어야 합니다.');
                e.preventDefault();
            }
            else if (nicknameChkState !== 1) {
                switch (nicknameChkState) {
                    case 0:
                        alert('다른 닉네임을 사용해 주세요!');
                        break;
                    case 2:
                        alert('닉네임 중복 체크를 해주세요!');
                        break;
                }
                e.preventDefault();
            }
        });

        joinFrmElem.u_nickname.addEventListener('keyup', () => {
            const nicknameChkMsgElem = joinFrmElem.querySelector('#nickname-chk-msg');
            nicknameChkMsgElem.innerText = '';
            nicknameChkState = 2;
        });

        joinFrmElem.u_nickname.addEventListener('change', () => {
            const nicknameVal = joinFrmElem.u_nickname.value;
            const nicknameChkMsgElem = joinFrmElem.querySelector('#nickname-chk-msg');

            if(nicknameVal.length < 2) {
                nicknameChkMsgElem.innerHTML = '닉네임은 2자 이상 작성해 주세요.';
                return;
            }else if(nicknameVal.length > 6){
                nicknameChkMsgElem.innerHTML = '닉네임은 6자 이하로 작성해 주세요.';
                return;
            }
            else if(!nicknameRegex.test(nicknameVal)) {
                nicknameChkMsgElem.innerHTML = '닉네임은 대소문자, 숫자 조합으로 2~6글자가 되어야 합니다.';
                return;
            }
            fetch(`/user/nicknameChk/${nicknameVal}`)
                .then(res => res.json())
                .then((data) => {
                    setnicknameChkMsg(data);
                }).catch((e)=> {
                console.log(e);
            });
        });
    }
}
