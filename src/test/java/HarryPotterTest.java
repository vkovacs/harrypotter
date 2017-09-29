import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class HarryPotterTest {
    @Test
    public void testNoBooks() {
        Assert.assertEquals(0, HarryPotter.calculatePrice(List.of()), 0);
    }

    @Test
    public void testOneBook() {
        Assert.assertEquals(8, HarryPotter.calculatePrice(List.of(1)), 0);
    }
}
