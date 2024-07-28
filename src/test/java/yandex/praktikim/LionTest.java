package yandex.praktikim;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LionTest {

    //не увидел тут смысла в моках, только если совсем изолироваться от Feline даже после инъекции
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(new Feline(), "Самец");
        var expected = List.of("Животные", "Птицы", "Рыба");
        var actual = lion.getFood();
        Assert.assertEquals("Не тот список еды",
                expected,
                actual);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(new Feline(), "Самка");
        int expected = 1;
        var actual = lion.getKittens();
        Assert.assertEquals("Не корретное значение кол-ва львят",
                expected,
                actual);
    }
}
