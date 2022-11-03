package service;

import java.util.ArrayList;
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


  // 회원정보조회 기능 메소드
  public MemberDto memberInfo(String sessionLoginId) {
    MemberDto mInfo = dao.selectMemberInfo(sessionLoginId);
    return mInfo;
  }

  // 회원목록 기능 메소드
  public ArrayList<MemberDto> memberList() {
    ArrayList<MemberDto> memberList = dao.selectMemberList();
    return memberList;
  }


  // 회원삭제 기능 메소드
  public int memberDelete(String delId) {
    int deleteResult = dao.deleteMemberInfo(delId);
    return deleteResult;
  }

  public int updateInfo(MemberDto updateMem) {
    int updateResult = dao.updateMemberInfo(updateMem);
    return updateResult;
  }
}
