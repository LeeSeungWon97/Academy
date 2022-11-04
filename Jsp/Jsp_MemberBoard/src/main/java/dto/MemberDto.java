package dto;

public class MemberDto {

  private String mid;
  private String mpw;
  private String mname;
  private String mbirth;
  private String maddr;

  private String emailId; // 이메일 아이디
  private String emailDomain; // 이메일 도메인
  private String memail; // 전체 이메일 주소

  private String mstate;

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

  public String getMbirth() {
    return mbirth;
  }

  public void setMbirth(String mbirth) {
    this.mbirth = mbirth;
  }

  public String getMaddr() {
    return maddr;
  }

  public void setMaddr(String maddr) {
    this.maddr = maddr;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getEmailDomain() {
    return emailDomain;
  }

  public void setEmailDomain(String emailDomain) {
    this.emailDomain = emailDomain;
  }

  public String getMemail() {
    return memail;
  }

  public void setMemail(String memail) {
    this.memail = memail;
  }

  public String getMstate() {
    return mstate;
  }

  public void setMstate(String mstate) {
    this.mstate = mstate;
  }

  @Override
  public String toString() {
    return "MemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth
        + ", maddr=" + maddr + ", memail=" + memail + "]";
  }


}
