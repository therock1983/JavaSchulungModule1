
package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.domain.price.DefaultPriceStrategy;
import at.edu.hti.shop.domain.price.IPriceCalculator;
import at.edu.hti.shop.domain.spec.ISpecification;

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

  public double calcWeight() {
    double weight = 0.0;
    for (OrderLine ol : orderLines) {
      weight += ol.calcWeight();
    }
    return weight;
  }

  private OrderLine searchOrderLine(long productId) {
    for (OrderLine ol : orderLines) {
      if (ol.getProduct().getId() == productId) {
        return ol;
      }
    }
    return null;
  }

  public List<Order> getPartOrdersBySpec(ISpecification specification) {
    List<OrderLine> lines = new ArrayList<>(orderLines);
    List<Order> partOrders = new ArrayList<>();

    Order partOrder = new Order();
    partOrders.add(partOrder);
    for (int i = 0; i < lines.size(); i++) {
      OrderLine ol = lines.get(i);
      if (specification.isSatisfiedBy(ol)) {
        partOrder.add(ol);
        orderLines.remove(ol);
      } else if (!orderLines.isEmpty()) {
        specification.reset();
        partOrder = new Order();
        partOrders.add(partOrder);

        i--;
      }
    }
    return partOrders;
  }

  public Order join(Order order) {
    this.orderLines.addAll(order.orderLines);
    return this;
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
    for (OrderLine ol : orderLines) {
      sb.append(ol).append("\n");
    }
    sb.append("Price  => ").append(calcPrize()).append("\n");
    sb.append("Weight => ").append(calcWeight());
    return sb.toString();
  }

  public int size() {
    return orderLines.size();
  }
}
