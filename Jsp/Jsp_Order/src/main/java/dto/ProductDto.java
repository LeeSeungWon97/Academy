package dto;

public class ProductDto {

  private String prcode;
  private String prbrand;
  private String prname;
  private int prprice;
  private String primg;

  public String getPrcode() {
    return prcode;
  }

  public void setPrcode(String prcode) {
    this.prcode = prcode;
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

  public String getPrimg() {
    return primg;
  }

  public void setPrimg(String primg) {
    this.primg = primg;
  }

  public void toString(ProductDto pdto) {
    System.out.println("상품코드: " + pdto.getPrcode());
    System.out.println("브랜드: " + pdto.getPrbrand());
    System.out.println("상품명: " + pdto.getPrname());
    System.out.println("가격: " + pdto.getPrprice());
    System.out.println("상품 이미지: " + pdto.getPrimg());
  }
}
