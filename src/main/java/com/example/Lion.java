package com.example;

import com.example.interfaces.injection.IFeline;

import java.util.List;

public class Lion {

    boolean hasMane;

    private IFeline feline;

    public Lion(Feline feline, String sex) throws Exception {

        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            //тут исправил "самей" на "самец", так как изначально была опечатка в тексте ошибки
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
