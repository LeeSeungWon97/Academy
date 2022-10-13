package day16;

public class ProductInfo {

  private int productNum;
  private String productName;
  private int productPrice;
  private int productCount;
  private String productType;

  public int getProductNum() {
    return productNum;
  }

  public void setProductNum(int productNum) {
    this.productNum = productNum;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(int productPrice) {
    if (productPrice < 0) {
      this.productPrice = 0;
    } else {
      this.productPrice = productPrice;
    }
  }

  public int getProductCount() {
    return productCount;
  }

  public void setProductCount(int productCount) {
    if (productCount < 0) {
      this.productCount = 0;
    } else {
      this.productCount = productCount;
    }
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  @Override
  public String toString() {
    return "[상품번호] " + productNum + " [상품이름] " + productName + " [상품가격] " + productPrice
        + " [상품수량] " + productCount + " [상품종류] " + productType;
  }


}
