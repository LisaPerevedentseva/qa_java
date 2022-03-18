package com.example;

import org.junit.Assert;
import org.junit.Test;

// Здесь лежат тесты для класса Animal без параметризации и моков

public class AnimalTest {

   final String incorrectAnimal = "Неизвестно";
   final String expectedTextForFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
   final String expectedTextForException="Неизвестный вид животного, используйте значение Травоядное или Хищник";


    // Негативный кейс: проверка исключения при попытке получить рацион неизвестного вида животного
  @Test
  public void textExceptionInGetFoodForAnimal() {
      Animal animal = new Animal();
      try {
          animal.getFood(incorrectAnimal);
          Assert.fail("Исключение не отработало");

      } catch (Exception thrown) {
          Assert.assertEquals(expectedTextForException, thrown.getMessage());
      }
  }

    @Test
    public void testGetFamily(){
        Animal animal = new Animal();
        Assert.assertEquals(expectedTextForFamily, animal.getFamily());
    }
}
