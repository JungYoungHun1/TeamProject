package com.gsbl.oneul.user;

import com.gsbl.oneul.Utils.Const;
import com.gsbl.oneul.Utils.UserUtils;
import com.gsbl.oneul.model.UserDTO;
import com.gsbl.oneul.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserUtils userUtils;

    // 회원가입
    @GetMapping("/user/join")
    public void join() {
    }

    @PostMapping("/user/join")
    public String joinProc(UserVO vo, RedirectAttributes reAttr) {
        int result = service.join(vo);
        if (result == 0) {
            reAttr.addFlashAttribute("msg", "회원가입에 실패하였습니다.");
            return "redirect:/user/join";
        }
        service.login(vo);
        return "redirect:/main";
    }
    // 아이디 중복 확인(회원가입)
    @GetMapping("/user/idChk/{u_id}")
    @ResponseBody
    public Map<String, Integer> idChk(@PathVariable String u_id) {
        Map<String, Integer> res = new HashMap();
        res.put("result", service.idChk(u_id));
        return res;
    }
    // 이메일 중복 확인(회원가입)
    @PostMapping("/user/emailChk")
    @ResponseBody
    public Map<String, Integer> emailChkProc(@RequestBody UserVO vo) {
        Map<String, Integer> res = new HashMap();
        res.put("email", service.emailChk(vo));
        return res;
    }


    // 로그인
    @GetMapping("/user/login")
    public void login() {
    }

    @PostMapping("/user/login")
    public String loginProc(UserVO vo, RedirectAttributes reAttr) {
        int result = service.login(vo);
        switch (result) {
            case 0:
                reAttr.addFlashAttribute("msg", "에러가 발생하였습니다.");
                break;
            case 1:
                return "redirect:/main";
            case 2:
                reAttr.addFlashAttribute("msg", "아이디를 확인해 주세요.");
                break;
            case 3:
                reAttr.addFlashAttribute("msg", "비밀번호를 확인해 주세요.");
                break;
        }
        return "redirect:/user/login";
    }

    //로그아웃
    @GetMapping("/user/logout")
    public String logout(HttpSession hs, HttpServletRequest req) {
        hs.invalidate();
        return "redirect:/main";
    }

    //카카오 로그인
    @PostMapping("/user/kakao")
    @ResponseBody
    public Map<String, Integer> kakaoProc(@RequestBody UserVO vo) {
        service.kakaoLogin(vo);

        Map<String, Integer> result = new HashMap<>();
        result.put("result", 1);
        return result;
    }
    //네이버 로그인
    @GetMapping("/naver/ncallback")
    public void ncallback() {
    }

    @PostMapping("/naver/ncallback")
    @ResponseBody
    public Map<String, Integer> ncallbackProc(@RequestBody UserVO vo) {
        service.naverLogin(vo);
        Map<String, Integer> result = new HashMap<>();
        result.put("result", 1);
        return result;
    }
    //구글 로그인

    @PostMapping("/user/google")
    @ResponseBody
    public Map<String, Integer> googleProc(@RequestBody UserVO vo) {
        service.googleLogin(vo);
        Map<String, Integer> result = new HashMap<>();
        result.put("result", 1);
        return result;
    }

    // 마이페이지
    @GetMapping("/user/mypage/profile")
    public void myPage() {
    }

    @ResponseBody
    @PostMapping("/user/mypage/profile")
    public Map<String, String> mypageProfileProc(MultipartFile u_profileimg) {
        String fileNm = service.uploadProfileImg(u_profileimg);
        Map<String, String> result = new HashMap<>();
        result.put("result", fileNm);
        return result;
    }

    // 비밀번호 변경(마이페이지)
    @GetMapping("user/mypage/password")
    public void password() {
    }

    @PostMapping("user/mypage/password")
    public String passwordProc(UserDTO dto, HttpSession hs, RedirectAttributes rAttr) {
        int result = service.changePassword(dto);
        if (result != 1) {
            switch (result) {
                case 0:
                    rAttr.addFlashAttribute("msg", "비밀번호 변경에 실패하였습니다.");
                    break;
                case 2:
                    rAttr.addFlashAttribute("msg", "현재 비밀번호를 확인해 주세요.");
                    break;
            }
            return "redirect:/user/mypage/password";
        }
        hs.invalidate();
        return "redirect:/user/logout";
    }

    // 현재 비밀번호 체크
    @PostMapping("/user/upwChk")
    @ResponseBody
    public Map<String, Integer> emailChkProc(@RequestBody UserDTO dto) {
        Map<String, Integer> res = new HashMap();
        res.put("upw", service.upwChk(dto));
        return res;
    }

    //닉네임 변경(마이페이지)
    @GetMapping("user/mypage/nickname")
    public void nickname() {
    }

    @PostMapping("user/mypage/nickname")
    public String nicknameProc(UserVO vo, HttpSession hs, RedirectAttributes rAttr) {
        int result = service.changeNickname(vo);
        if (result != 1) {
            switch (result) {
                case 0:
                    rAttr.addFlashAttribute("err", "닉네임 변경에 실패하였습니다.");
                    break;
            }
            return "redirect:/user/mypage/nickname";
        }
        hs.invalidate();
        return "redirect:/user/logout";
    }

    // 닉네임 중복 체크(닉네임 변경)
    @GetMapping("/user/nicknameChk/{u_nickname}")
    @ResponseBody
    public Map<String, Integer> nicknameChk(@PathVariable String u_nickname) {
        Map<String, Integer> res = new HashMap();
        res.put("nickname", service.nicknameChk(u_nickname));
        return res;
    }
}
