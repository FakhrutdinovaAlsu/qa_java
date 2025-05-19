import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionNegativeTest {

    @Mock
    private Feline feline;

    @Test
    public void testWithIncorrectSex() throws Exception {
        try {
            Lion lion = new Lion("Мужской", feline);
            fail("Тест не пройден");
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка",exception.getMessage());
        }
    }

    @Test
    public void shouldReturnOneKitten() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void shouldGetFoodForLion() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);
        assertEquals(expectedFood,lion.getFood());
    }

    @Test
    public void testGetFoodForLionThrowsException() throws Exception {
        String error = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenThrow((new Exception(error)));
        try {
            lion.getFood();
            fail("Ожидалось исключение");
        } catch (Exception exception) {
            assertEquals(error, exception.getMessage());
        }
    }
}