
package at.edu.hti.shop;

import java.util.List;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.spec.ISpecification;
import at.edu.hti.shop.domain.spec.WeightSpecification;

public class App {
  public static void main(String[] args) {

    //    Order shopOrder = new Order();
    //
    //    OrderLine line1 = new OrderLine(new Product(1, "Äpfel", 1.2, 0.2, 2), 4);
    //    OrderLine line2 = new OrderLine(new Product(2, "Birnen", 1.5, 0.3, 1), 2);
    //
    //    OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2, 0.1, 1), 5);
    //    OrderLine line4 = new OrderLine(new Product(4, "Kiwi", 3.5, 0.1, 2), 6);
    //
    //    shopOrder.add(line1);
    //    shopOrder.add(line2);
    //    System.out.println(shopOrder.size());
    //    System.out.println(shopOrder);
    //
    //    shopOrder.setAmount(line1.getProduct().getId(), 8);
    //
    //    System.out.println(shopOrder.size());
    //    System.out.println(shopOrder);
    //
    //    shopOrder.setAmount(line2.getProduct().getId(), 0);
    //
    //    System.out.println(shopOrder.size());
    //    System.out.println(shopOrder);
    //
    //    shopOrder.add(line3);
    //    shopOrder.add(line4);

    simpleTest();
  }

  public static void simpleTest() {
    Order mainOrder = new Order();

    OrderLine line1 = new OrderLine(new Product(1, "Produkt1", 5.99, 2.0, 2), 4);
    OrderLine line2 = new OrderLine(new Product(2, "Produkt2", 8.99, 1.0, 2), 3);
    OrderLine line3 = new OrderLine(new Product(3, "Produkt3", 1.99, 0.5, 2), 1);
    OrderLine line4 = new OrderLine(new Product(4, "Produkt4", 2.99, 0.25, 2), 1);
    OrderLine line5 = new OrderLine(new Product(5, "Produkt5", 3.99, 1.25, 2), 1);

    mainOrder.add(line1);
    mainOrder.add(line2);
    mainOrder.add(line3);
    mainOrder.add(line4);
    mainOrder.add(line5);

    System.out.println(mainOrder);
    System.out.println();

    ISpecification spec = new WeightSpecification(8);

    List<Order> partOrderList = mainOrder.getPartOrdersBySpec(spec);
    for (Order order : partOrderList) {
      System.out.println(order);
      System.out.println();
    }

    System.out.println();
    System.out.println();

    Order newOrder = partOrderList.get(0);
    newOrder.join(partOrderList.get(1));

    System.out.println(newOrder);
  }
}
