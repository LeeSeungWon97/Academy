/*
 * 자바에서 홈페이지 접속
 * 페이지 정보 가져오기
 * 수집할 데이터 선택
 * 선택한 데이터를 String 타입으로 변환
 */

package jsoupTest;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import dao.OrderDao;
import dto.ProductDto;

public class JsoupTest {

  public static void main(String[] args) {
    // 1. 데이터를 수집할 페이지 URL
    String oliveURL = "https://www.oliveyoung.co.kr/store/main/getBestList.do";
    OrderDao odao = new OrderDao();

    try {
      // 2. URL 접속 후 페이지 문서객체 반환
      Document doc = Jsoup.connect(oliveURL).get();
      /*
       * 데이터를 수집할 select영역
       * ex) #Container > div.best-area > div.TabsConts.on
       */
      Elements bestDiv = doc.select("#Container > div.best-area > div.TabsConts.on");
      Elements productList = bestDiv.get(0).select("li");
      int listSize = productList.size();
      System.out.println("선택된 li 태그 수: " + listSize);

      int result = 0;

      for (int i = 0; i < listSize; i++) {
        // 상품코드 생성
        int prNum = odao.selectMaxProductNum() + 1;

        String productCode = "P" + String.format("%04d", prNum);

        // 브랜드명
        String brandName = productList.get(i).select("span.tx_brand").get(0).text();

        // 상품명
        String productName =
            productList.get(i).select("p.tx_name").get(0).text().replaceAll("(\\[)(.*?)(\\])","").trim();
        int splitlength = productName.split("]").length;
        productName = productName.split("]")[splitlength - 1];

        // 상품가격
        String productPrice_text =
            productList.get(i).select("span.tx_num").get(0).text().replace(",", "");
        int productPrice = Integer.parseInt(productPrice_text);

        // 상품이미지 src 값
        // 이미지
        String productImg = productList.get(i).select("div > a > img").attr("src");
        System.out.println(productImg);

        ProductDto prInfo = new ProductDto();
        prInfo.setPrcode(productCode);
        prInfo.setPrbrand(brandName);
        prInfo.setPrname(productName);
        prInfo.setPrprice(productPrice);
        prInfo.setPrimg(productImg);

        System.out.println("상품이름: " + prInfo.getPrname());

        ProductDto checkPrname = odao.searchProduct(productName);

        // 상품이름 중복확인
        if (checkPrname.getPrname() == null) {
          result += odao.insertProduct(prInfo);
        }
        System.out.println();
      }

      System.out.println("등록 완료 상품: " + result + "개");

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
