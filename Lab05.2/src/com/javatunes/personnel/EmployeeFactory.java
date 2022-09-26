/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;


public class EmployeeFactory {



  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {
    // return value
    Employee emp = null;
    String type = inputMap.get("type");
    //TODO If type is not equal to "HE" or "SE", then throw IllegalArgumentException
    //TODO Read the name and hireDate from inputMap. (Remember: All of the values in the map are strings, but hireDate is java.sql.Date.)
    //TODO If type is equal to "HE", then read (and parse) rate and hours from inputMap.
    //TODO If equal to "SE", then read (and parse) salary from inputMap.
    //TODO Create and return an instance of HourlyEmployee or SalaryEmployee, with the values read from inputMap.

    String name = inputMap.get("name");
    Date hireDate = Date.valueOf(inputMap.get("hireDate"));
    if (type.equals("SE")) {
      Double salary = Double.valueOf(inputMap.get("salary"));
      emp = new SalariedEmployee(name, hireDate, salary);
    } else if (type.equals("HE")) {
      Double rate = Double.valueOf(inputMap.get("rate"));
      Double hours = Double.valueOf(inputMap.get("hours"));
      emp = new HourlyEmployee(name, hireDate, rate, hours);
    }

    else {
      throw new IllegalArgumentException("unsupported type " + type);
    }
    return emp;
  }
}