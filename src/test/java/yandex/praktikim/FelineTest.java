package yandex.praktikim;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    //По идее покрытие 100% и без этих тестов было достигнуто, но на всякий случай решил
    //использовать Spy, как в одном из уроков, так как место подходящее
    @Spy
    Feline feline;

    @Test
    public void getKittensWithoutParamsSpyTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParamsSpyTest() {
        int expected = 10;
        var actual = feline.getKittens(10);
        Assert.assertEquals("Кол-во не совпадает",
                expected,
                actual);
    }

    @Test
    public void getFamilyTest() {
        var expected = "Кошачьи";
        var actual = new Feline().getFamily();
        Assert.assertEquals("Не то семейство",
                expected,
                actual);
    }

    @Test
    public void eatMeat() {
        var expected = List.of("Животные", "Птицы", "Рыба");
        try {
            var actual = new Feline().eatMeat();
            Assert.assertEquals("Не тот список еды",
                    expected,
                    actual);
        } catch (Exception ex) {
            Assert.assertEquals("Не ожидаемая ошибка",
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    ex.getMessage());
        }
    }
}
