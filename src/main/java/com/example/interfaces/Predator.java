package com.example.interfaces;

import java.util.List;

//передвинул интерфейс Predator в пакет интерфейсов, раз уж я его создал
public interface Predator {

    List<String> eatMeat() throws Exception;

}
