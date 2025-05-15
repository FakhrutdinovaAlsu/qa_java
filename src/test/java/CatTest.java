import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void catShouldSayMew() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void shouldGetFoodForCat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        when(cat.getFood()).thenReturn(expectedFood);
        assertEquals(expectedFood,cat.getFood());
    }
}