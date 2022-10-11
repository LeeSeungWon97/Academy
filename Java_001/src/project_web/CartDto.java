package project_web;

public class CartDto {

  private String cId;
  private String cCode;
  private String cName;
  private int cPrice;
  private int cAmount;
  private int pTotal;

  public String getcId() {
    return cId;
  }

  public void setcId(String cId) {
    this.cId = cId;
  }

  public String getcCode() {
    return cCode;
  }

  public void setcCode(String cCode) {
    this.cCode = cCode;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }

  public int getcPrice() {
    return cPrice;
  }

  public void setcPrice(int cPrice) {
    this.cPrice = cPrice;
  }

  public int getcAmount() {
    return cAmount;
  }

  public void setcAmount(int cAmount) {
    this.cAmount = cAmount;
  }

  public int getpTotal() {
    return pTotal;
  }

  public void setpTotal(int pTotal) {
    this.pTotal = pTotal;
  }

  @Override
  public String toString() {
    return "[" + cName + "] [" + cPrice + "] [" + cAmount + "] [" + pTotal + "]";
  }



}
