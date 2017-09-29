import java.util.List;
import org.junit.Assert;

public class HarryPotterTest {
    public void testNoBooks() {
        Assert.assertEquals(0, HarryPotter.calculatePrice(List.of()), 0);
    }
}
