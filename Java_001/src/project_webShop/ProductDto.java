package project_webShop;

public class ProductDto {

  private String pdCode;
  private String pdName;
  private int pdPrice;
  private int pdAmount;
  private String pdType;

  public String getPdCode() {
    return pdCode;
  }

  public void setPdCode(String pdCode) {
    this.pdCode = pdCode;
  }

  public String getPdName() {
    return pdName;
  }

  public void setPdName(String pdName) {
    this.pdName = pdName;
  }

  public int getPdPrice() {
    return pdPrice;
  }

  public void setPdPrice(int pdPrice) {
    this.pdPrice = pdPrice;
  }

  public int getPdAmount() {
    return pdAmount;
  }

  public void setPdAmount(int pdAmount) {
    this.pdAmount = pdAmount;
  }

  public String getPdType() {
    return pdType;
  }

  public void setPdType(String pCode) {
    String code = "";

    for (int i = 0; i < 2; i++) {
      code += pCode.charAt(i);
    }


    switch (code) {
      case "PO":
        this.pdType = "아우터";
        break;

      case "PT":
        this.pdType = "상의";
        break;

      case "PP":
        this.pdType = "바지";
        break;

      case "PS":
        this.pdType = "신발";
    }
  }

  @Override
  public String toString() {
    return "[" + pdName + "] [" + pdPrice + "] [" + pdAmount + "]";
  }



}
