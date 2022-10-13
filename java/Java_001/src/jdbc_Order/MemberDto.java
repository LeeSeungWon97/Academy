package jdbc_Order;

public class MemberDto {

  private String mid; // 아이디
  private String mpw; // 비밀번호
  private String mname; // 이름
  private int mgender; // 성별(남: 1,3 / 여: 2,4)
  private String mbirth; // 생일
  private String memail; // 이메일

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

  public int getMgender() {
    return mgender;
  }

  public void setMgender(int mgender) {
    this.mgender = mgender;
  }

  public String getMbirth() {
    return mbirth;
  }

  public void setMbirth(String mbirth) {
    this.mbirth = mbirth;
  }

  public String getMemail() {
    return memail;
  }

  public void setMemail(String memail) {
    this.memail = memail;
  }



}
