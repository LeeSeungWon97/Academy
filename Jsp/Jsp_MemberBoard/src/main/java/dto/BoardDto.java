package dto;

public class BoardDto {

  private int bno;
  private String btitle;
  private String bwriter;
  private String bcontent;
  private String bdate;
  private int bhits;
  private String bfilename;
  private String bstate;

  public int getBno() {
    return bno;
  }

  public void setBno(int bno) {
    this.bno = bno;
  }

  public String getBtitle() {
    return btitle;
  }

  public void setBtitle(String btitle) {
    this.btitle = btitle;
  }

  public String getBwriter() {
    return bwriter;
  }

  public void setBwriter(String bwriter) {
    this.bwriter = bwriter;
  }

  public String getBcontent() {
    return bcontent;
  }

  public void setBcontent(String bcontent) {
    this.bcontent = bcontent;
  }

  public String getBdate() {
    return bdate;
  }

  public void setBdate(String bdate) {
    this.bdate = bdate;
  }

  public int getBhits() {
    return bhits;
  }

  public void setBhits(int bhits) {
    this.bhits = bhits;
  }

  public String getBfilename() {
    return bfilename;
  }

  public void setBfilename(String bfilename) {
    this.bfilename = bfilename;
  }

  public String getBstate() {
    return bstate;
  }

  public void setBstate(String bstate) {
    this.bstate = bstate;
  }


}
