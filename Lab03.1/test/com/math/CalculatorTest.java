/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// @FixMethodOrder(MethodSorters.JVM)
public class CalculatorTest {

  private Calculator calc;

  @Before
  public void beforeEach() {
    System.out.println("@Before");
  calc = new Calculator();
  // creates a new instance of calculator for each test
  }

  @Test
  public void testAdd() {

    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void testDivide() {

    assertEquals(2.5, calc.divide(5, 2), 0.001);
  }

  @Test
  public void testIsEven() {

    assertTrue(calc.isEven(10));
  }

  @After
  public void cleanup() {
    System.out.println("@After");
    // Do tear down code
  }
}