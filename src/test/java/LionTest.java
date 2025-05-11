import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {
    private String sex;
    private boolean expectedHaveMane;

    public LionTest(String sex, boolean expectedHaveMane) {
        this.sex = sex;
        this.expectedHaveMane = expectedHaveMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: sex, expectedHaveMane")
    public static Object [][] data() {
        return new Object[][] {
                {"Самец",true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    @Test
    public void shouldReturnOneKitten() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, feline);
        assertEquals(1,lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectSex() throws Exception {
        Lion lion = new Lion("Мужской",feline);
    }

    @Test
    public void doesHavaMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHaveMane,lion.doesHaveMane());
    }

    @Test
    public void shouldGetFoodForLion() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedFood,lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testGetFoodForLionThrowsException() throws Exception {
        Lion lion = new Lion(sex, feline);
        when(feline.getFood("Хищник")).thenThrow((new Exception()));
        lion.getFood();
    }
}