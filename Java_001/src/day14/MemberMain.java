package day14;

// 기능 호출 및 실행
public class MemberMain {
	public static void main(String[] args) {

		MemberManager manager = new MemberManager();
		boolean run = true;

		while (run) {
			String loginId = manager.getLoginId();

			// 메뉴 출력 및 선택 메소드 호출
			int selectMenu = manager.showMenu();
			System.out.println("선택한 메뉴 : " + selectMenu);

			// selectMenu
			// [로그인 X]
			// [1]회원가입		[2]로그인		[3]아이디찾기 		[4]종료
			// [로그인 O]
			// [1]내정보		[2]로그아웃	[3]내정보 수정		[4]종료
			
			switch (selectMenu) {

			case 1:
				// 회원가입 기능 메소드 호출
				if (loginId == null) {
					manager.memberJoin();
				} else {
					manager.memberInfo();
				}
				break;

			// 로그인 기능 메소드 호출
			case 2:

				if (loginId == null) {
					// 로그인 메소드
					manager.memberLogin();
				} else { 
					// 로그아웃 메소드
					manager.memberLogout();
				}
				break;

			// 아이디 기능 메소드 호출	
			case 3:
				// 아이디 찾기 기능 메소드
				if (loginId == null) {
					manager.memberFind();
				}
				// 내정보 수정 기능 메소드
				else {
					manager.memberUpdate();
				}
				break;

			// 종료 기능	
			case 4:
				run = false;
				break;

			}
		}

	}

}
