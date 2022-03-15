package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

   List<String> expectedDiet = List.of("Животные", "Птицы", "Рыба"); // ожидаемый рацион для кота
   String expectedSound = "Мяу";

    @Test // Проверка звука, который издает кошка
    public void testGetSound (){
        Cat cat = new Cat ();
        Assert.assertEquals(expectedSound, cat.getSound());
    }

     @Test // проверяем, что getFood возвращает корректный рацион для кота
    public void testGetFood() throws Exception{
        Cat cat = new Cat();
        Assert.assertEquals(expectedDiet, cat.getFood());
     }


}
