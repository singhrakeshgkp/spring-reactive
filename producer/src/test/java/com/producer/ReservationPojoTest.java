package com.producer;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ReservationPojoTest {

  @Test
  public void create(){
    Reservation reservation = new Reservation("001","rakesh");
    assertEquals(reservation.getId(),"001");
    assertNotNull(reservation.getName());
  }
}
