package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

// все тесты с моками

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    Lion lion;

    @Mock
    Feline feline;

    // Ожидаемые результаты для тестов

    //Ожидаемое количество котят для льва
    final int expectedKittens = 1;

    // звук, ожидаемый от кошки
    final String expectedSound = "Мяу";

    // ожидаемый текст исключения при создании льва с некорректным полом
    final String textOfException = "Используйте допустимые значения пола животного - самец или самка";

    // Параметр для передачи в конструктор теста testExceptionInLionConstructor()
    final String sex = "Неизвестно";

    // Ожидаемый список еды для кота
    final List<String> expectedEatForCat = List.of("Животные", "Птицы", "Рыба");

    // Ожидаемый список еды для льва
    final List<String> expectedEatForLion = List.of("Животные", "Птицы", "Рыба");

    // Негативный сценарий для конструктора льва: отработка исключения при некорректном поле
    @Test
    public void testExceptionInLionConstructor() {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.fail("Исключение не отработало");
        } catch (Exception thrown) {
            Assert.assertEquals(textOfException, thrown.getMessage());
        }
    }


    // Исправленный тест testReturnGetKittenForLion()
    @Test
    public void testReturnGetKittenForLion() throws Exception {
        Lion lion = new Lion ("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(expectedKittens,lion.getKittens());
    }


   // Исправленный тест testReturnGetFoodForLion()
    @Test
    public void testReturnGetFoodForLion() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(expectedEatForLion, lion.getFood());
    }

    @Test // Проверка звука, который издает кошка
    public void testGetSoundForCat (){
        Cat cat = new Cat (feline);
        Assert.assertEquals(expectedSound, cat.getSound());
    }


    // Исправленный тест testGetFoodForCat()
    @Test
    public void testGetFoodCat() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(expectedEatForCat, cat.getFood());
    }

}
