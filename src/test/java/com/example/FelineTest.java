
package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class FelineTest {

    List<String> expectedEat = List.of("Животные", "Птицы", "Рыба");// ожидаемый рацион для кошачьих
    String expectedFamily = "Кошачьи";

    Feline feline = new Feline();

    @Test // проверяем, что метод возвращает семейство "Кошачьи"
    public void testGetFamily() {
        String actual = feline.getFamily();
        Assert.assertEquals(expectedFamily, actual);
    }

    @Test // Проверяем, что метод возвращает введенное количество котят
    public void testGetKittensWithArgument (){
        int expected = 5;
        int actual = feline.getKittens(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensWithoutArgument() {
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }


    @Test // проверяем, что метод возвращает еду для хищника
    public void testEatMeat() throws Exception {
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expectedEat, actual);
    }

}
