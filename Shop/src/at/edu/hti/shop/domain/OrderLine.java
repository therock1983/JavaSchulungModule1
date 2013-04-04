
package at.edu.hti.shop.domain;

public class OrderLine {
  private Product product;
  private int amount;

  public OrderLine(Product product, int amount) {
    super();
    this.product = product;
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Product getProduct() {
    return product;
  }

  public double calcPrize() {
    return amount * product.getPrize();
  }

  public double calcWeight() {
    return amount * product.getWeight();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof OrderLine)) {
      return false;
    }
    OrderLine ol = (OrderLine) obj;
    return ol.product.equals(product);
  }

  @Override
  public String toString() {
    return "OrderLine [" + product + ", " + amount + "]";
  }

}
