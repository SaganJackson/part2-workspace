/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * Domestic orders have a graduated tax scheme:
 *  The first $20.00 is tax-free.
 *  Amount over $20.00 is taxed at 10.0%.
 *  
 * TODO: implement this algorithm.
 */
public class USATax implements TaxCalculator {

  @Override
  public double taxAmount(double taxable) {
    double result = 0.0;
    double taxableOver20 = taxable - 20.0;

    if (taxableOver20 > 0.0) {
      result = taxableOver20 * 0.1;
    }
    return result;
  }

}