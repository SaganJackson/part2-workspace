/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

public interface TaxCalculator {
  public double taxAmount(double taxable);

  static public TaxCalculator getInstance(Location origin) {
    TaxCalculator taxCalc = null;

    switch (origin) {
      case USA:
        taxCalc = new USATax();
        break;
      case EUROPE:
        taxCalc = new EuropeTax();
        break;
      case ONLINE:
        taxCalc = new OnlineTax();
        break;
    }
    return taxCalc;
  }
}