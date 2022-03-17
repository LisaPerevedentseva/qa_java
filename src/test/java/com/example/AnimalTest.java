package com.example;

import org.junit.Assert;
import org.junit.Test;

// Здесь лежат тесты для класса Animal без параметризации и моков

public class AnimalTest {

    String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Test
    public void testGetFamily(){
        Animal animal = new Animal();
        Assert.assertEquals(expectedText, animal.getFamily());
    }
}
