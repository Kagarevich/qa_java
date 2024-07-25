package yandex.praktikim.parameterized;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expected;

    public LionParameterizedTest(
            String sex,
            boolean expected
    ) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                //Тут вылетит ошибка, но на всякий случай поставил false, так как проверка на самца
                {"Сам", false}
        };
    }

    @Test
    public void doesHaveManeParameterizedTest() {
        try {
            Lion lion = new Lion(new Feline(), sex);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals("Некорректно заполнился пол льва",
                    expected,
                    actual);
        } catch (Exception ex) {
            Assert.assertEquals("Не ожидаемая ошибка",
                    "Используйте допустимые значения пола животного - самец или самка",
                    ex.getMessage());
        }
    }
}
