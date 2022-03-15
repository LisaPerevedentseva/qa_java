package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

// Параметризованный тест для getFood

@RunWith(Parameterized.class)
public class AnimalParamTest {

     private final AnimalKind animalKind;
     private final List<String> expected; // ожидаемый рацион для созданного животного
     private final String textOfException; // ожидаемый текст исключения при создании некорректного животного
     private final String textAboutFamily; // текст, ожидаемый в getFamily()

     public AnimalParamTest(AnimalKind animalKind, List<String> expected){
         this.animalKind = animalKind;
         this.expected=expected;
         this.textOfException="Неизвестный вид животного, используйте значение Травоядное или Хищник";
         this.textAboutFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
     }


    @Parameterized.Parameters
     public static Object[][] testGetFoodData (){
        return new Object[][] {
                {AnimalKind.HERBIVORE, List.of("Трава", "Различные растения")},
                {AnimalKind.PREDATOR, List.of("Животные", "Птицы", "Рыба")},
                {AnimalKind.INCORRECT, List.of()}
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

    @Test
    public void testGetFamily(){
         Animal animal = new Animal();
         Assert.assertEquals(textAboutFamily, animal.getFamily());
    }
}
