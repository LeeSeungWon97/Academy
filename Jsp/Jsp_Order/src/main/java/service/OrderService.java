package service;

import java.util.ArrayList;
import dao.OrderDao;
import dto.ProductDto;

public class OrderService {
  OrderDao odao = new OrderDao();

  public ArrayList<ProductDto> showProductList() {
    System.out.println("OrderService showProductList() 호출");
    ArrayList<ProductDto> productList = odao.selectProductList();
    
    return productList;
  }

}
