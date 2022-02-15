package com.gsbl.oneul.user;

import com.gsbl.oneul.model.UserDTO;
import com.gsbl.oneul.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int join(UserVO vo);            //회원가입
    UserVO idChk(UserVO vo);        //아이디 중복 체크(회원가입)
    UserVO emailChk(UserVO vo);     //이메일 중복 체크(회원가입)

    UserVO selUser(UserVO vo);      //DB 계정 유무 확인
    UserVO login(UserVO vo);        //로그인
    int updUser(UserVO vo);         // 비밀번호 변경 && 프로필 이미지 변경
    UserVO changeUser(UserVO vo);   // 유저 정보 셀렉트

    int updNickname(UserVO vo);     //닉네임 변경(마이페이지)
    UserVO nicknameChk(UserVO vo);  //닉네임 중복 체크(닉네임 변경)

}
