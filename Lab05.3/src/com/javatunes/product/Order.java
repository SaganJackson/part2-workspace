/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import java.util.Collection;


public class Order {
  private String id;
  private double totalCost;
  private Location origin;
  
  public Order(String id) {
    this.id = id;
  }

  public Order(String id, Location origin) {
    this.id = id;
    this.origin = origin;
  }
  
  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }

    double total = cart.total();
    System.out.println("Order Total: " + cart.total());
    totalCost = total;
  }
  
  public String getId() {
    return id;
  }

  public double getTax() {
    TaxCalculator taxCalc = TaxCalculator.getInstance(origin);
    return taxCalc.taxAmount(totalCost);
  }

  public Location getOrigin() {
    return this.origin;
  }

  public void setOrigin(Location origin) {
    this.origin = origin;
  }

  public double getTotalCost() {
    return totalCost;
  }
}