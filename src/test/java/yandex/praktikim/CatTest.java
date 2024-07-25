package yandex.praktikim;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodMockedMeatListTest() {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Мясо", "Рыба");
        try {
            Mockito.when(feline.eatMeat()).thenReturn(expected);
            var actual = cat.getFood();
            Assert.assertEquals("Не тот список еды",
                    actual,
                    expected);
        } catch (Exception ex) {
            Assert.assertEquals("Не ожидаемая ошибка",
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    ex.getMessage());
        }

    }

    @Test
    public void getSoundDefaultTest() {
        //Тут можно было подставлять мок feline, а не использовать new Feline()
        //Скорость выполнения теста одинаковая в обоих случаях (+- несколько миллисекунд)
        Cat cat = new Cat(new Feline());
        String actual = cat.getSound();
        Assert.assertEquals("Кот издал не тот звук!",
                "Мяу",
                actual);
    }
}
