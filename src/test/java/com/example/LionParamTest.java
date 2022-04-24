package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// Параметризованные тесты для класса Lion:
// 1. Проверка всех условий конструктора
// 2. Проверка, что doesHasMane возвращает пол животного

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expected; // ожидаемое значение параметра, определяющего наличие гривы

    public LionParamTest(String sex, boolean expected){
        this.sex=sex;
        this.expected=expected;
    }

    @Parameterized.Parameters
    public static Object[][] testLionConstructorData() { // источник данных для метода, возвращает двумерный массив
        return new Object[][] {
                //Пол    //Наличие гривы
                {"Самец", true}, // корректный пол
                {"Самка", false} // корректный пол
        };
    }

    // положительные сценарии: проверяем, что при создании льва у самца есть грива, у самки нет
    @Test
    public void testLionConstructor () throws Exception {
            Lion lion = new Lion(sex, new Feline());
            boolean actual = lion.hasMane;
            Assert.assertEquals(expected, actual);

    }

    // положительные сценарии: проверяем корректность работы метода doesHaveMane при корректном поле
    @Test
    public void testDoesHaveMane () throws Exception {
            Lion lion = new Lion(sex, new Feline()); // создаем поочередно самца, самку
            boolean actual = lion.doesHaveMane(); // вызываем проверяемый метод
            Assert.assertEquals(expected, actual);

    }


}
