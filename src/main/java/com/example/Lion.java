package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    // добавляем инъекцию зависимости, чтобы изолировать класс Lion от Feline

    private Feline feline; // в эту переменную передадим экземпляр класса Feline
    // в конструктор передаем пол льва и объект класса Feline, который будет создан в другом классе - DI

    public Lion(String sex, Feline feline) throws Exception {

        this.feline=feline; // присваиваем полю класса созданный объект
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

     public int getKittens() {
        return feline.getKittens();
     }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}