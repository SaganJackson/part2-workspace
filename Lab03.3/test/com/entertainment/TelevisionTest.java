package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelevisionTest {

  private final Television tv1 = new Television("Samsung", 0, DisplayType.OLED);
  @Test
  public void testSetVolume() {
    //Television tv = new Television();
    int volume = Television.MIN_VOLUME + Television.MAX_VOLUME;
    tv1.setVolume(volume);
    assertEquals(volume, tv1.getVolume());


  }

  @Test
  public void testSetVolumeIllegalArgumentException() {
    int oldVolume = tv1.getVolume();
    int volume = Television.MIN_VOLUME -1;
    try {

      tv1.setVolume(volume);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals(oldVolume, tv1.getVolume());
    }
  }

  @Test
  public void testChangeChannel() throws InvalidChannelException {
    int channel = (Television.MIN_CHANNEL + Television.MAX_CHANNEL) / 2;
    tv1.changeChannel(channel);
    assertEquals(channel, tv1.getCurrentChannel());
  }

  @Test
  public void testChangeChannelInvalidChannelException() {
    int oldChannel = tv1.getCurrentChannel();
    int channel = Television.MAX_CHANNEL + 1;

    try {
      tv1.changeChannel(channel);
      fail();
    } catch (InvalidChannelException e) {
      assertEquals(oldChannel, tv1.getCurrentChannel());
    }

  }



  @Test
  public void testCompareTo() {
    Television tv2 = new Television("Sony");
    assertTrue(tv1.compareTo(tv2) < 0);
    Television tv3 = new Television("LG");
    assertTrue(tv1.compareTo(tv3) > 0);
  }

  @Test
  public void testHashCode() {
    Television tv2 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1.hashCode(), tv2.hashCode());
    Television tv3 = new Television ("Samsung", 1, DisplayType.OLED);
    assertEquals(tv1.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
    Television tv2 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1, tv2);
    Television tv3 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv1, tv3);
  }
}