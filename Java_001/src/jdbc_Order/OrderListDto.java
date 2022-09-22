package jdbc_Order;

public class OrderListDto {
  private int odnum;
  private String odmid;
  private String oddate;
  private String odpdcode;
  private int odqty;

  public int getOdnum() {
    return odnum;
  }

  public void setOdnum(int odnum) {
    this.odnum = odnum;
  }

  public String getOdmid() {
    return odmid;
  }

  public void setOdmid(String odmid) {
    this.odmid = odmid;
  }

  public String getOddate() {
    return oddate;
  }

  public void setOddate(String oddate) {
    this.oddate = oddate;
  }

  public String getOdpdcode() {
    return odpdcode;
  }

  public void setOdpdcode(String odpdcode) {
    this.odpdcode = odpdcode;
  }

  public int getOdqty() {
    return odqty;
  }

  public void setOdqty(int odqty) {
    this.odqty = odqty;
  }


}
