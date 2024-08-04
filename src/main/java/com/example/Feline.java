package com.example;

import com.example.interfaces.Predator;
import com.example.interfaces.injection.IFeline;

import java.util.List;

public class Feline extends Animal implements Predator, IFeline {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
