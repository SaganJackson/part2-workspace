package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private static  final double SALARY = 500000;
  private static  final double TOLERANCE = 0.001;
  private static  final double TAX = SALARY * TaxPayer.SALARIED_TAX_RATE;

  private Employee emp;


  @Before
  public void setUp() throws Exception{
    emp = new SalariedEmployee("Steve Jobs", new Date(2021, 0, 1 ), SALARY);
  }

  @Test
  public void testPay() {
    assertEquals(SALARY, emp.pay(), TOLERANCE);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(TAX, emp.payTaxes(), TOLERANCE);
  }
}