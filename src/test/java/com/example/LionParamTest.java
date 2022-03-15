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
    private final String textOfException; // ожидаемый текст исключения при создании льва с некорректным полом

    public LionParamTest(String sex, boolean expected){
        this.sex=sex;
        this.expected=expected;
        this.textOfException = "Используйте допустимые значения пола животного - самец или самка";
    }

    @Parameterized.Parameters
    public static Object[][] testLionConstructorData() { // источник данных для метода, возвращает двумерный массив
        return new Object[][] {
                //Пол    //Наличие гривы
                {"Самец", true}, // корректный пол
                {"Самка", false}, // корректный пол
                {"Оно", false} // некорректный пол

        };
    }

    @Test // проверяем, что при создании льва у самца есть грива, у самки нет, а если пол неизвестен - срабатывает исключение с соответствующим текстом
    public void testLionConstructor () throws Exception {
        try { // проверяем два положительных сценария
            Lion lion = new Lion(sex, new Feline());
            boolean actual = lion.hasMane;
            Assert.assertEquals(expected, actual);
        } catch (Exception exception) { // проверяем наличие и текст исключения в случае, если пол животного некорректный
            Assert.assertEquals(textOfException, exception.getMessage());
        }
    }

    @Test // проверяем корректность работы метода doesHaveMane
    public void testDoesHaveMane () throws Exception {
        try {
            Lion lion = new Lion(sex, new Feline()); // создаем поочередно самца, самку и некорректный пол
            boolean actual = lion.doesHaveMane(); // вызываем проверяемый метод
            Assert.assertEquals(expected, actual);
        }
        catch (Exception exception) {
            Assert.assertEquals(textOfException, exception.getMessage());
        }
    }





}
