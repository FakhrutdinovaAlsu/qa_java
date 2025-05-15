import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
}
