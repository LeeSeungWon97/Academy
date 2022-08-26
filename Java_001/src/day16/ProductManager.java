package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {

  Scanner scan = new Scanner(System.in);

  private ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();

  // 메뉴 출력 및 기능 선택 메소드
  public int showMenu() {
    System.out.println("======================================================================");
    System.out.println(" [1]상품 등록 | [2]상품 검색 | [3] 상품 정보 수정 | [4]상품 리스트 출력 | [5]종료");
    System.out.println("======================================================================");
    System.out.print("메뉴선택>>");
    return scan.nextInt();
  }


  // 인덱스 찾기 메소드
  private int searchIndex(String product) {

    int idx = -1;
    for (int i = 0; i < productList.size(); i++) {
      String productName = productList.get(i).getProductName();
      String productType = productList.get(i).getProductType();

      if (product.equals(productName) || product.equals(productType)) {
        idx = i;
      }
    }
    return idx;
  }


  /* [1] 상품 등록 메소드 */

  // 상품 중복체크 메소드(이름)

  private String productNameCheck() {

    String productName;

    while (true) {
      System.out.print("상품이름>>");
      productName = scan.next();

      int idx = searchIndex(productName);

      if (idx == -1) {
        break;
      } else {
        System.out.println("이미 등록된 상품입니다.");
      }
    }
    return productName;
  }


  // 새 상품 리스트 추가 메소드
  public void productRegister() {
    System.out.println("[ 상품 등록 ]");

    ProductInfo newProduct = new ProductInfo();

    newProduct.setProductName(productNameCheck());

    int productNum = productList.size() + 1;

    newProduct.setProductNum(productNum);

    System.out.print("상품가격>>");
    newProduct.setProductPrice(scan.nextInt());

    System.out.print("상품수량>>");
    newProduct.setProductCount(scan.nextInt());

    System.out.print("상품종류>>");
    newProduct.setProductType(scan.next());

    productList.add(newProduct);

    System.out.println("\n[새 상품 등록완료]");
    System.out.println(newProduct);
    System.out.println();
  }

  /* [2] 상품 검색 메소드 */

  // 검색유형 확인 메소드
  public int selectCase() {

    System.out.print("선택>>");
    int selectNum = scan.nextInt();

    return selectNum;
  }

  // 상품 검색 메소드
  public void productSearch() {
    System.out.println("[1] 이름으로 검색 | [2] 상품 종류로 검색");
    int selectNum = selectCase();

    if (selectNum == 1) {
      nameSearch();
    } else if(selectNum == 2){
      typeSearch();
    } else {
      ;
    }
  }

  // 이름으로 검색 메소드
  private void nameSearch() {
    System.out.print("상품 이름>>");
    String productName = scan.next();
    int idx = searchIndex(productName);

    if (idx == -1) {
      System.out.println("상품을 찾을 수 없습니다.");
    } else {
      System.out.println("[상품이름] " + productList.get(idx).getProductName());
      System.out.println("[상품가격] " + productList.get(idx).getProductPrice());
      System.out.println("[상품수량] " + productList.get(idx).getProductCount());
      System.out.println("[상품종류] " + productList.get(idx).getProductType());
    }
  }


  // 상품종류로 검색 메소드
  private void typeSearch() {
    System.out.print("상품 종류>>");
    String producttype = scan.next();

    int idx = searchIndex(producttype);

    if (idx > -1) {
      System.out.println("[ 전체상품 목록 ]");
      for (int i = 0; i < productList.size(); i++) {
        if (productList.get(i).getProductType().equals(producttype)) {
          System.out.println(productList.get(i));

        }
      }
    } else {
      System.out.println("상품을 찾을 수 없습니다.");
    }
  }

  /* [3] 상품정보 수정 */

  // 상품정보 수정 메소드
  public void infoChange() {
    System.out.println("[상품수정]");

    System.out.print("수정할 상품이름>>");
    int idx = searchIndex(scan.next());
    if (idx > -1) {
      System.out.println("[검색된 상품 정보]");
      System.out.println(productList.get(idx));

      System.out.println("\n[1]가격수정 | [2]재고수정");

      int selectNum = selectCase();
      switch (selectNum) {
        case 1:
          System.out.print("변경할 가격>>");
          int price = scan.nextInt();
          productList.get(idx).setProductPrice(price);
          break;
        case 2:
          System.out.print("재고 입력>>");
          int count = scan.nextInt();
          productList.get(idx).setProductCount(count);
        default:
      }
    } else {
      System.out.println("상품을 찾을 수 없습니다.");
    }

  }


  /* [4]상품 리스트 출력 */
  public void showList() {

    System.out.println("[상품전체 리스트]");

    if(productList.size()>0) {
      for (int i = 0; i < productList.size(); i++) {
        System.out.println(productList.get(i));
      }      
    } else {
      System.out.println("등록된 상품이 없습니다.\n");
    }
  }



}
