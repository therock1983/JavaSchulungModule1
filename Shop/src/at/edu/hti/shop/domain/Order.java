
package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.domain.price.DefaultPriceStrategy;
import at.edu.hti.shop.domain.price.IPriceCalculator;

public class Order {

  private List<OrderLine> orderLines = new ArrayList<OrderLine>();
  private IPriceCalculator priceCalculator = new DefaultPriceStrategy();

  public Order() {
  }

  public Order(IPriceCalculator priceCalculator) {
    this.priceCalculator = priceCalculator;
  }

  public boolean add(OrderLine ol) {
    if (ol == null)
      return false;

    if (ol.getProduct() == null)
      return false;

    OrderLine tmpOl = searchOrderLine(ol.getProduct().getId());
    if (tmpOl != null) {
      tmpOl.setAmount(tmpOl.getAmount() + ol.getAmount());
    } else {
      orderLines.add(ol);
    }
    return true;
  }

  public double calcPrize() {
    return priceCalculator.calulcatePrice(orderLines);
  }

  private OrderLine searchOrderLine(long productId) {
    for (OrderLine ol : orderLines) {
      if (ol.getProduct().getId() == productId) {
        return ol;
      }
    }
    return null;
  }

  public boolean setAmount(long productId, int amount) {
    if (productId < 0)
      return false;
    if (amount < 0)
      return false;

    OrderLine ol = searchOrderLine(productId);
    if (ol == null)
      return false;

    if (amount == 0) {
      orderLines.remove(ol);
    } else {
      ol.setAmount(amount);
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(orderLines).append("\n").append(" => ").append(calcPrize());
    return sb.toString();
  }

  public int size() {
    return orderLines.size();
  }
}
