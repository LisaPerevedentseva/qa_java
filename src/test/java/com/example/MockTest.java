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

    // звук, ожидаемый от кошки
    final String EXPECTED_SOUND = "Мяу";
    // ожидаемый текст исключения при создании льва с некорректным полом
    final String TEXT_OF_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";
    // Параметр для передачи в конструктор теста testExceptionInLionConstructor()
    final String SEX = "Неизвестно";

    // Негативный сценарий для конструктора льва: отработка исключения при некорректном поле
    @Test
    public void testExceptionInLionConstructor() {
        try {
            Lion lion = new Lion(SEX, feline);
            Assert.fail("Исключение не отработало");
        } catch (Exception thrown) {
            Assert.assertEquals(TEXT_OF_EXCEPTION, thrown.getMessage());
        }
    }

    @Test
    public void testReturnGetKittenForLion() throws Exception {
        Lion lion = new Lion ("Самец", feline);
        lion.getKittens();
        // проверяем, что в рамках метода lion.getKittens() вызвался feline.getKittens()
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testReturnGetFoodForLion() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        lion.getFood();
        // проверяем, что в рамках метода lion.getFood() вызвался feline.getFood("Хищник")
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test // Проверка звука, который издает кошка
    public void testGetSoundForCat (){
        Cat cat = new Cat (feline);
        Assert.assertEquals(EXPECTED_SOUND, cat.getSound());
    }

    @Test // Проверка, что в рамках getFood() для Cat вызывается eatMeat() для Feline
    public void testGetFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

}
