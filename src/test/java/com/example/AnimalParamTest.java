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
     private final String textOfException; // ожидаемый текст исключения при создании некорректного животного


     public AnimalParamTest(String animalKind, List<String> expected){
         this.animalKind = animalKind;
         this.expected=expected;
         this.textOfException="Неизвестный вид животного, используйте значение Травоядное или Хищник";
     }


    @Parameterized.Parameters
     public static Object[][] testGetFoodData (){
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Неизвестно", List.of()}
        };

    }

    @Test
    public void testGetFood() throws Exception {
         try {
         Animal animal = new Animal();
         List<String> actual = animal.getFood(animalKind);
         Assert.assertEquals(expected, actual);
         } catch (Exception exception) {
             Assert.assertEquals(textOfException, exception.getMessage());
         }
    }


}
