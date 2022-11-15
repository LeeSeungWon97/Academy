package dto;

public class OrderInfoDto {
  private String orcode;
  private String prbrand;
  private String prname;
  private int prprice;
  private String ordate;

  public String getOrcode() {
    return orcode;
  }

  public void setOrcode(String orcode) {
    this.orcode = orcode;
  }

  public String getPrbrand() {
    return prbrand;
  }

  public void setPrbrand(String prbrand) {
    this.prbrand = prbrand;
  }

  public String getPrname() {
    return prname;
  }

  public void setPrname(String prname) {
    this.prname = prname;
  }

  public int getPrprice() {
    return prprice;
  }

  public void setPrprice(int prprice) {
    this.prprice = prprice;
  }

  public String getOrdate() {
    return ordate;
  }

  public void setOrdate(String prdate) {
    this.ordate = prdate;
  }


}
