package com.qagroup.car.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qagroup.Car;

public class CarTest {

 private static final String BMW = "BMW";

 private static final String X5 = "X5";

 String initialColor = "Blue";

 private Car car;

 @BeforeMethod
 public void setup() {
  car = new Car(initialColor, BMW, X5);
 }

 @Test
 public void testColorInitialization() {
  Assert.assertEquals(car.getColor(), initialColor,
    "Incorrect color initialization in constructor. Input value: " + initialColor);
 }

 @Test
 public void testChangeColor() {
  String changedColor = "White";
  car.changeColor(changedColor);

  Assert.assertEquals(car.getColor(), changedColor, "Incorrect changed color.");
 }
}