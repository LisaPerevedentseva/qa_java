package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

// Здесь лежат тесты для класса Animal, для которых необходима параметризация:
// Метод getFood для разных видов животных: Травоядное, Хищник, Неизвестное

@RunWith(Parameterized.class)
public class AnimalParamTest {

     private final String animalKind;
     private final List<String> expected; // ожидаемый рацион для созданного животного

     public AnimalParamTest(String animalKind, List<String> expected){
         this.animalKind = animalKind;
         this.expected=expected;
     }

    @Parameterized.Parameters
     public static Object[][] testGetFoodData (){
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };

    }

    // положительный сценарий: определяем раион животного при корректном виде - Травоядное или Хищник
    // убрала проверку исключений из данного теста
    @Test
    public void testGetFood() throws Exception {
         Animal animal = new Animal();
         List<String> actual = animal.getFood(animalKind);
         Assert.assertEquals(expected, actual);
    }

}
