package day14;

import java.util.Scanner;

// 기능 정의
public class MemberManager {

	private Scanner scan = new Scanner(System.in);

	// 로그인 확인
	private String loginId = null;
	int myIndex = -1;

	public String getLoginId() {
		return loginId;
	}

	// 메뉴 출력 기능 메소드
	public int showMenu() {
		if (loginId == null) {
			System.out.println("\n========================================");
			System.out.println("[1]회원가입 | [2]로그인 | [3]아이디찾기 | [4]종료");
			System.out.println("========================================");
		} else {
			System.out.println("\n========================================");
			System.out.println("[1]내정보 | [2]로그아웃 | [3]내정보수정 | [4]종료");
			System.out.println("========================================");
		}
		System.out.print("메뉴선택>>");
		int selectMenu = scan.nextInt();
		return selectMenu;
	}

	/* selectMenu == 1 인 경우 */

	// 회원 정보 저장 배열
	private MemberInfo[] memberList = new MemberInfo[100];

	// 가입된 회원 수
	private int memberCount = 0;

	// 아이디 중복 체크 메소드
	private String idCheck() {
		String mid = null;

		while (true) {
			System.out.print("가입할 아이디>>");
			mid = scan.next();

			boolean check = true;

			for (int i = 0; i < memberList.length; i++) {
				if (memberList[i] != null) {
					if (memberList[i].getMid().equals(mid)) {
						check = false;
					}
				}
			}
			if (check) {
				break;
			} else {
				System.out.println("이미 사용중인 아이디 입니다.");
			}
		}

		return mid;
	}

	// 회원가입 기능 메소드
	public void memberJoin() {
		System.out.println("[회원가입]");
		
		String mid = idCheck();

		System.out.print("가입할 비밀번호>>");
		String mpw = scan.next();

		System.out.print("가입할 이름>>");
		String mname = scan.next();

		System.out.print("가입할 이메일>>");
		String memail = scan.next();

		System.out.print("가입할 전화번호>>");
		String mphone = scan.next();

		MemberInfo member = new MemberInfo();

		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMemail(memail);
		member.setMphone(mphone);

		memberList[memberCount] = member;
		memberCount++;

		if (memberCount == memberList.length) {
			memberCount = 0;
		}

		System.out.println("회원가입 되었습니다.");

	}

	public void memberInfo() {
		System.out.println(memberList[myIndex].toString());
	}

	/* selectMenu == 2 인 경우 */

	// 로그인 기능 메소드
	public void memberLogin() {

		System.out.println("[로그인]");

		System.out.print("아이디>>");
		String userId = scan.next();

		System.out.print("비밀번호>>");
		String userPw = scan.next();

		// 입력한 아이디, 비밀번호 일치하는 회원 정보 검색
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null) {
				if (userId.equals(memberList[i].getMid()) && userPw.equals(memberList[i].getMpw())) {
					myIndex = i;
				}
			}
		}

		// 일치하는 정보가 있는 경우
		if (myIndex > -1) {
			System.out.println("로그인 되었습니다.");
			loginId = memberList[myIndex].getMid();
		}

		// 일치하지 정보가 없는 경우
		else {
			System.out.println("아이디/비밀번호가 일치하지 않습니다.");
		}
	}

	public void memberLogout() {

		System.out.print("로그아웃을 하시겠습니까? ([1]Yes [2]No)>>");
		int selectLogout = scan.nextInt();

		if (selectLogout == 1) {
			loginId = null;
			myIndex = -1;
			System.out.println("로그아웃 되었습니다.");
		}

	}

	/* selectMenu == 3 인 경우 */

	// 아이디 찾기 메소드
	public void memberFind() {
		System.out.println("[아이디 찾기]");

		System.out.print("이름 입력>>");
		String userName = scan.next();

		System.out.print("이메일 입력>>");
		String userEmail = scan.next();

		int idx = -1;

		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null) {
				if (userName.equals(memberList[i].getMname()) && userEmail.equals(memberList[i].getMemail())) {
					idx = i;
				}
			}
		}

		if (idx > -1) {
			System.out.println("아이디는 " + memberList[idx].getMid() + "입니다.");
		} else {
			System.out.println("일치하는 회원 정보가 없습니다.");
		}
	}

	// 정보 수정 메소드
	public void memberUpdate() {
		System.out.println("[내정보 수정]");
		int idx = -1;
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null) {
				if (loginId.equals(memberList[i].getMid())) {
					idx = i;
				}
			}
		}

		System.out.print("새로운 이메일 입력>>");
		String meamil = scan.next();
		System.out.print("새로운 전화번호 입력>>");
		String mphone = scan.next();
		memberList[idx].setMemail(meamil);
		memberList[idx].setMphone(mphone);
		System.out.println("정보가 수정 되었습니다.");
	}

}
