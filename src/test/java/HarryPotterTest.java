import org.junit.Assert;
import org.junit.Test;

public class HarryPotterTest {
    @Test
    public void testNoBooks() {
        Assert.assertEquals(0, HarryPotter.calculatePrice(new int[0]), 0);
    }

    @Test
    public void testOneBook() {
        Assert.assertEquals(8, HarryPotter.calculatePrice(new int[] { 1 }), 0);
    }

    @Test
    public void testTwoDifferentBooks() {
        Assert.assertEquals(2 * 8 * 0.95, HarryPotter.calculatePrice(new int[] { 1, 1 }), 0);
    }

    @Test
    public void testTwoDifferentBooksAndOneSimilar() {
        Assert.assertEquals(2 * 8 * 0.95 + 8, HarryPotter.calculatePrice(new int[] { 2, 1 }), 0);
    }
}
