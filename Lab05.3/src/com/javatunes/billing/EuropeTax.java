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
 * European orders are taxed as follows:
 *  VAT is 17% of taxable amount.
 *  Luxury tax is an additional 25% on amount over $100.
 *  
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator {

  @Override
  public double taxAmount(double taxable) {
    double vat = 0.17 * taxable;
    double luxury = 0.0;

    double taxableOver100 = taxable - 100;
    if (taxableOver100 > 0) {
      luxury = taxableOver100 * 0.25;
    }
    return vat + luxury;
  }
}