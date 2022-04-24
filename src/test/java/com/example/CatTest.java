package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

// здесь лежат тесты для класса Cat, для которых не нужны моки и параметризация

public class CatTest {

    List<String> expectedDiet = List.of("Животные", "Птицы", "Рыба"); // ожидаемый рацион для кота
    Cat cat = new Cat (new Feline());

     @Test // проверяем, что getFood возвращает корректный рацион для кота
    public void testGetFood() throws Exception{
        Assert.assertEquals(expectedDiet, cat.getFood());
     }


}
