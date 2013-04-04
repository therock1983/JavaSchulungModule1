
package at.edu.hti.shop.domain;

public class Product {
  private String name;
  private long id;
  private double prize;
  private int deliveryTime;
  private double weight;

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Product(long id, String name, double prize, double weight, int deliveryTime) {
    super();
    this.name = name;
    this.id = id;
    this.prize = prize;
    this.weight = weight;
    this.deliveryTime = deliveryTime;
  }

  public String getName() {
    return name;
  }

  public long getId() {
    return id;
  }

  public double getPrize() {
    return prize;
  }

  public int getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(int deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Product)) {
      return false;
    }
    Product otherProd = (Product) obj;
    return otherProd.id == id;
  }

  @Override
  public String toString() {
    return "Product [" + name + ", " + id + ", " + prize + ", " + weight + ", " + deliveryTime + "]";
  }
}