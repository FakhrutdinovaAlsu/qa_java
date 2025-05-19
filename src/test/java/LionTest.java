import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

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
    public void doesHavaMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHaveMane,lion.doesHaveMane());
    }
}