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
    String loginId = mdao.selectMemberLogin(inputId,inputPw);
    return loginId;
  }

}
