package project_web;

public class MemberDto {

  private String mId;
  private String mPw;
  private String mName;
  private int mGender;
  private String mBirth;
  private String mEmail;
  private int mCash;
  private String mGrade;
  private String mCheck;
  private int mTotal;

  public String getmId() {
    return mId;
  }

  public void setmId(String mId) {
    this.mId = mId;
  }

  public String getmPw() {
    return mPw;
  }

  public void setmPw(String mPw) {
    this.mPw = mPw;
  }

  public String getmName() {
    return mName;
  }

  public void setmName(String mName) {
    this.mName = mName;
  }

  public int getmGender() {
    return mGender;
  }

  public void setmGender(int mGender) {
    this.mGender = mGender;
  }

  public String getmBirth() {
    return mBirth;
  }

  public void setmBirth(String mBirth) {
    this.mBirth = mBirth;
  }

  public String getmEmail() {
    return mEmail;
  }

  public void setmEmail(String mEmail) {
    this.mEmail = mEmail;
  }

  public int getmCash() {
    return mCash;
  }

  public void setmCash(int mCash) {
    this.mCash = mCash;
  }

  public String getmGrade() {
    return mGrade;
  }

  public void setmGrade(String mGrade) {
    this.mGrade = mGrade;
  }

  public String getmCheck() {
    return mCheck;
  }

  public void setmCheck(String mCheck) {
    this.mCheck = mCheck;
  }

  public int getmTotal() {
    return mTotal;
  }

  public void setmTotal(int mTotal) {
    this.mTotal = mTotal;
  }

  @Override
  public String toString() {
    return "[" + mId + "] [" + mPw + "] [" + mName + "] [" + mGender + "] [" + mBirth + "] ["
        + mEmail + "] [" + mCash + "] [" + mGrade + "] [" + mCheck + "] [" + mTotal + "]";
  }

}
