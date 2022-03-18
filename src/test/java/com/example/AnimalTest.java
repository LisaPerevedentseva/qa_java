package com.example;

import org.junit.Assert;
import org.junit.Test;

// Здесь лежат тесты для класса Animal без параметризации и моков

public class AnimalTest {

   final String INCORRECT_ANIMAL = "Неизвестно";
   final String EXPECTED_TEXT_FOR_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
   final String EXPECTED_TEXT_FOR_EXCEPTION="Неизвестный вид животного, используйте значение Травоядное или Хищник";


    // Негативный кейс: проверка исключения при попытке получить рацион неизвестного вида животного
  @Test
  public void textExceptionInGetFoodForAnimal() {
      Animal animal = new Animal();
      try {
          animal.getFood(INCORRECT_ANIMAL);
          Assert.fail("Исключение не отработало");

      } catch (Exception thrown) {
          Assert.assertEquals(EXPECTED_TEXT_FOR_EXCEPTION, thrown.getMessage());
      }
  }

    @Test
    public void testGetFamily(){
        Animal animal = new Animal();
        Assert.assertEquals(EXPECTED_TEXT_FOR_FAMILY, animal.getFamily());
    }
}
