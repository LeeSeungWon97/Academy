package service;

import java.util.ArrayList;
import dao.OrderDao;
import dto.OrderInfoDto;
import dto.ProductDto;

public class OrderService {
  OrderDao odao = new OrderDao();

  public ArrayList<ProductDto> showProductList() {
    System.out.println("OrderService showProductList() 호출");
    ArrayList<ProductDto> productList = odao.selectProductList();

    return productList;
  }

  public int order(String prcode, String id) {
    System.out.println("OrderService order() 호출");
    String orderNum = odao.selectMaxOrderNum();
    if (orderNum == null) {
      orderNum = "O" + String.format("%04d", 1);
    } else {
      int num = Integer.parseInt(odao.selectMaxOrderNum().replace("O", ""));
      orderNum = "O" + String.format("%04d", num + 1);
    }
    System.out.println(orderNum);
    System.out.println("OrderNum: " + orderNum);
    int result = odao.insertOrder(prcode, id, orderNum);
    return result;
  }

  public ArrayList<OrderInfoDto> showOrderInfo(String mid) {
    System.out.println("OrderService showOrderInfo() 호출");
    ArrayList<OrderInfoDto> orderInfo = odao.selectOrderInfo(mid);

    return orderInfo;
  }

}
