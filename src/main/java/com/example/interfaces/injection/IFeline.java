package com.example.interfaces.injection;

import java.util.List;

//Решил не менять другие классы, кроме Lion,
//а просто добавил интерфейс для инъекции, как было написано в уроке
public interface IFeline {

    int getKittens();

    int getKittens(int kittensCount);

    List<String> getFood(String animalKind) throws Exception;
}
