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

    private String expectedSound = "Мяу";

    @Test // Проверка, что getFood успешно вызывается у льва
    public void testCallingGetFoodForLion() throws Exception{
        lion.getFood();
        Mockito.verify(lion).getFood();

    }

    @Test // Проверка, что getKittens успешно вызывается у льва
    public void testCallingGetKittenForLion() {
        lion.getKittens();
        Mockito.verify(lion).getKittens();
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
        Assert.assertEquals(expectedSound, cat.getSound());
    }

    @Test // Проверка, что в рамках getFood() для Cat вызывается eatMeat() для Feline
    public void testGetFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

}
