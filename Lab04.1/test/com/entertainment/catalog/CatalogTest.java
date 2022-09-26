/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(7, tvs.size());
  }

  @Test
  public void testFindByBrandsNoBrands() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
    assertNotNull(tvMap);
    assertTrue(tvMap.isEmpty());
  }

  @Test
  public void testFindByBrandsSomeBrands() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "No Matches");
    assertNotNull(tvMap);
    assertFalse(tvMap.isEmpty());
    assertEquals(3, tvMap.size()); //map with the 3 specified brands
    assertEquals(7, tvMap.get("Sony").size());
    assertEquals(9, tvMap.get("Zenith").size());
    assertEquals(0, tvMap.get("No Matches").size());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testGetInventoryReturnsCatalog() {
    Collection<Television> inventory = Catalog.getInventory();
    inventory.clear();
  }
}