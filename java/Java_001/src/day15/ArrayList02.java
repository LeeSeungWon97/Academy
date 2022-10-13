// ArrayList에 Class 넣기


package day15;

import java.util.ArrayList;

import day14.MemberInfo;

public class ArrayList02 {

	public static void main(String[] args) {
		ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		String mid = "아이디";
		String mpw = "비밀번호";
		String mname = "이름";
		String memail = "이메일";
		String mphone = "전화번호";
		
		MemberInfo member = new MemberInfo();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMemail(memail);
		member.setMphone(mphone);
		
		memberList.add(member);

		
		System.out.println("mid: " + memberList.get(0).getMid());

		System.out.println("mid: " + memberList.get(0).getMemail());
		
		String newEmail = "새 이메일";
		// 0번 인덱스의 memberList에 저장된 member의 email값을 변경
		memberList.get(0).setMemail(newEmail);
		System.out.println("mid: " + memberList.get(0).getMemail());
	}

}
