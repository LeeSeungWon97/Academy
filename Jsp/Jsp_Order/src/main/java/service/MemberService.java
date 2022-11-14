package service;

import dao.MemberDao;

public class MemberService {

  MemberDao mdao = new MemberDao();

  public String loginCheck(String inputId, String inputPw) {
    System.out.println("MemberService loginCheck() 호출");
    String loginId = mdao.selectMemberLogin(inputId, inputPw);

    return loginId;
  }

}
