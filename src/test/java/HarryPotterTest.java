import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class HarryPotterTest {
    @Test
    public void testNoBooks() {
        List<Integer> books = new ArrayList<>();
        Assert.assertEquals(0, HarryPotter.calculatePrice(books), 0);
    }

    @Test
    public void testOneBook() {
        List<Integer> books = new ArrayList<>();
        books.add(1);
        Assert.assertEquals(8, HarryPotter.calculatePrice(books), 0);
    }

    @Test
    public void testTwoDifferentBooks() {
        List<Integer> books = new ArrayList<>();
        books.add(1);
        books.add(1);
        Assert.assertEquals(2 * 8 * 0.95, HarryPotter.calculatePrice(books), 0);
    }

    @Test
    public void testTwoDifferentBooksAndOneSimilar() {
        List<Integer> books = new ArrayList<>();
        books.add(2);
        books.add(1);
        Assert.assertEquals(2 * 8 * 0.95 + 8, HarryPotter.calculatePrice(books), 0);
    }
}
