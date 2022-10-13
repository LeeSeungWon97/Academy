package day14;

// 회원 정보
public class MemberInfo {

	// 회원 아이디
	private String mid;

	// 회원 비밀번호
	private String mpw;
	
	// 회원 이름
	private String mname;
	
	// 회원 이메일
	private String memail;
	
	// 회원 전화번호
	private String mphone;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	@Override
	public String toString() {
		return "[아이디: " + mid + "]\n[이름: " + mname + "]\n[이메일: " + memail + "]\n[전화번호: " + mphone + "]";
	}
	
	
}
