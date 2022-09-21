package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {

  private HourlyEmployee emp;

  @Before
  public void setUp() {
    emp = new HourlyEmployee("Oprah Winfrey", new Date(120, 2, 21), 2000.00, 40.00);
  }

  @Test
  public void testPay() {
    assertEquals(80000, emp.pay(), 0.001);
  }

  @Test
  public void testPayTaxes() {
//    double expected = 20000;
//    double actual = emp.payTaxes();
//    assertEquals(expected, actual, 0.001);

    assertEquals(20000, emp.payTaxes(), 0.001);
  }
}