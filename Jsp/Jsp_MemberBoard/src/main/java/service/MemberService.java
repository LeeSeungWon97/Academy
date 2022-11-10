package service;

import dao.MemberDao;
import dto.MemberDto;

public class MemberService {

  MemberDao mdao = new MemberDao();

  // 회원가입 메소드
  public int memberJoin(MemberDto joinMember) {
    System.out.println("MemberService memberJoin()호출");
    int insertResult = mdao.insertMemberJoin(joinMember);
    return insertResult;
  }


  // 로그인 메소드
  public String memberLogin(String inputId, String inputPw) {
    String loginId = mdao.selectMemberLogin(inputId, inputPw);
    return loginId;
  }


  // 아이디 중복확인 메소드
  public String memberIdCheck(String inputId) {
    System.out.println("MemberService memberIdCheck() 호출");
    String checkResult = "OK";

    MemberDto memInfo = mdao.selectMemberInfo(inputId);

    if (memInfo != null) {
      checkResult = "NO";
    }

    return checkResult;
  }


  public MemberDto loginMemberInfo(String id) {
    System.out.println("MemberService loginMemberInfo() 호출");
    MemberDto loginInfo = mdao.selectMemberInfo(id);
    System.out.println(loginInfo.toString());
    return loginInfo;
  }

}
