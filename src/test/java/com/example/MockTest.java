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

    @Test // Проверка, что getFood успешно вызывается у льва
    public void testGetFood() throws Exception{
        lion.getFood();
        Mockito.verify(lion).getFood();

    }

    @Test // Проверка, что getKittens успешно вызывается у льва
    public void testGetKitten() {
        lion.getKittens();
        Mockito.verify(lion).getKittens();
    }


    @Test
    public void testReturnGetKitten() throws Exception {
        Lion lion = new Lion ("Самец", feline);
        lion.getKittens();
        // проверяем, что в рамках метода lion.getKittens() вызвался feline.getKittens()
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testReturnGetFood() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        lion.getFood();
        // проверяем, что в рамках метода lion.getFood() вызвался feline.getFood(AnimalKind.PREDATOR)
        Mockito.verify(feline).getFood(AnimalKind.PREDATOR);
    }

}
