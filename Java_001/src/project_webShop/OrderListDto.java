package project_web;

public class OrderListDto {

  private int odNum;
  private String odMid;
  private String odDate;
  private String odPdCode;
  private int odAmount;

  public int getOdNum() {
    return odNum;
  }

  public void setOdNum(int odNum) {
    this.odNum = odNum;
  }

  public String getOdMid() {
    return odMid;
  }

  public void setOdMid(String odMid) {
    this.odMid = odMid;
  }

  public String getOdDate() {
    return odDate;
  }

  public void setOdDate(String odDate) {
    this.odDate = odDate;
  }

  public String getOdPdCode() {
    return odPdCode;
  }

  public void setOdPdCode(String odPdCode) {
    this.odPdCode = odPdCode;
  }

  public int getOdAmount() {
    return odAmount;
  }

  public void setOdAmount(int odAmount) {
    this.odAmount = odAmount;
  }

}
