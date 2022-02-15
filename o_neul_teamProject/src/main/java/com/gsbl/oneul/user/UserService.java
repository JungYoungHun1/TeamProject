package com.gsbl.oneul.user;

import com.gsbl.oneul.Utils.Const;
import com.gsbl.oneul.Utils.MyFileUtils;
import com.gsbl.oneul.Utils.UserUtils;
import com.gsbl.oneul.model.UserDTO;
import com.gsbl.oneul.model.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private MyFileUtils myFileUtils;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private HttpSession hs;

    //로컬 회원가입
    public int join(UserVO vo) {
        String plainPw = vo.getU_pw();
        vo.setU_pw(BCrypt.hashpw(vo.getU_pw(), BCrypt.gensalt())); //암호화
        vo.setU_pfnum(1);
        int result = mapper.join(vo);
        vo.setU_pw(plainPw);
        return result;
    }

    // 아이디 중복 체크(회원가입)
    public int idChk(String u_id) {
        UserVO vo = new UserVO();
        vo.setU_id(u_id);

        UserVO result = mapper.idChk(vo);
        return result == null ? 1 : 0;
    }

    // 이메일 중복 체크(회원가입)
    public int emailChk(UserVO vo) {
        UserVO result = mapper.emailChk(vo);
        return result == null ? 1 : 0;
    }



    //로컬 로그인
    public int login(UserVO vo) {
        UserVO loginUser = null;
        try {
            loginUser = mapper.login(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; //에러 발생
        }

        if (loginUser == null) {
            return 2;
        }
        //암호 비교
        if (BCrypt.checkpw(vo.getU_pw(), loginUser.getU_pw())) {
            loginUser.setU_pw(null);
            loginUser.setU_rdt(null);
            hs.setAttribute("loginUser", loginUser);
            return 1;
        }
        return 3;
    }

    // DB에 계정 유무 확인(플랫폼 로그인)
    public UserVO selUser(UserVO vo) {
        return mapper.selUser(vo);
    }

    //네이버 로그인
    public void naverLogin(UserVO vo) {
        vo.setU_pfnum(2);
        vo.setU_pw("0");
        vo.setU_pw(BCrypt.hashpw(vo.getU_pw(), BCrypt.gensalt()));
        vo.setU_id(vo.getU_email().substring(0, vo.getU_email().indexOf("@")));
        UserVO loginUser = selUser(vo);
        if (loginUser == null) {
            mapper.join(vo);
            loginUser = selUser(vo);
        }
        hs.setAttribute("loginUser", loginUser);
    }

    //카카오 로그인
    public void kakaoLogin(UserVO vo) {
        vo.setU_pfnum(3);
        vo.setU_pw("0");
        vo.setU_pw(BCrypt.hashpw(vo.getU_pw(), BCrypt.gensalt()));
        vo.setU_id(vo.getU_email().substring(0, vo.getU_email().indexOf("@")));
        UserVO loginUser = selUser(vo);
        if (loginUser == null) {
            mapper.join(vo);
            loginUser = selUser(vo);
        }
        hs.setAttribute("loginUser", loginUser);
    }

    //구글 로그인
    public void googleLogin(UserVO vo) {
        vo.setU_pfnum(4);
        vo.setU_pw("0");
        vo.setU_pw(BCrypt.hashpw(vo.getU_pw(), BCrypt.gensalt()));
        vo.setU_id(vo.getU_email().substring(0, vo.getU_email().indexOf("@")));
        UserVO loginUser = selUser(vo);
        if (loginUser == null) {
            mapper.join(vo);
            loginUser = selUser(vo);
        }
        hs.setAttribute("loginUser", loginUser);
    }

    //프로필 사진 업로드(마이페이지)
    public String uploadProfileImg(MultipartFile mf) {
        if (mf == null) {
            return null;
        }

        UserVO loginUser = userUtils.getLoginUser();

        final String PATH = Const.UPLOAD_IMG_PATH + "/user/" + loginUser.getIuser();
        String fileNm = myFileUtils.saveFile(PATH, mf);
        if (fileNm == null) {
            return null;
        }

        UserVO vo = new UserVO();
        vo.setIuser(loginUser.getIuser());

        //기존 파일명 담기
        String oldFilePath = PATH + "/" + loginUser.getU_profileimg();
        myFileUtils.delFile(oldFilePath);

        //파일명 DB에 업데이트
        vo.setU_profileimg(fileNm);
        mapper.updUser(vo);

        //세션 프로필 파일명 수정
        loginUser.setU_profileimg(fileNm);

        return fileNm;
    }

    // 비밀번호 변경(마이페이지)
    public int changePassword(UserDTO dto) {
        dto.setIuser(userUtils.getLoginUserPk());
        UserVO vo = mapper.changeUser(dto);
        if (!BCrypt.checkpw(dto.getCurrentupw(), vo.getU_pw())) {
            return 2; //현재 비밀번호 다름
        }
        String hashedPw = BCrypt.hashpw(dto.getU_pw(), BCrypt.gensalt());
        dto.setU_pw(hashedPw);
        return mapper.updUser(dto);
    }

    // 닉네임 변경(마이페이지)
    public int changeNickname(UserVO vo) {
        vo.setIuser(userUtils.getLoginUserPk());
        UserVO result = mapper.changeUser(vo);
        return mapper.updNickname(vo);
    }

    // 닉네임 중복 체크(닉네임 변경)
    public int nicknameChk(String u_nickname) {
        UserVO vo = new UserVO();
        vo.setU_nickname(u_nickname);

        UserVO result = mapper.nicknameChk(vo);
        return result == null ? 1 : 0;
    }

    // 비밀번호 변경시 현재 비밀번호 체크
    public int upwChk(UserDTO dto) {
        dto.setIuser(userUtils.getLoginUserPk());
        UserVO vo = mapper.changeUser(dto);
        if (!BCrypt.checkpw(dto.getCurrentupw(), vo.getU_pw())) {
            return 0; //현재 비밀번호 다름
        }
        return 1;
    }


}
