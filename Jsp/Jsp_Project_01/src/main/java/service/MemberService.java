package service;

import dao.MemberDao;
import dto.MemberDto;

public class MemberService {

  private MemberDao dao = new MemberDao();

  // 회원가입 기능 메소드
  public int memberJoin(MemberDto joinMember) {
    int insertResult = dao.insertMember(joinMember);

    return insertResult;
  }

  // 로그인 기능 메소드
  public String memberLogin(String inputId, String inputPw) {
    String loginMid = dao.login(inputId, inputPw);
    return loginMid;
  }
}
