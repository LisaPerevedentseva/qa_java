package com.example;

import java.util.List;

// Наследуем класс Feline, т.к. все коты принадлежат семейству Кошачьих

public class Cat extends Feline { // теперь наследуем все методы Feline, Feline в свою очередь наследует Animal и имплементирует Predator

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return eatMeat();
    }

}