import java.util.Arrays;

public class HarryPotter {
    private static final int BOOK_PRICE = 8;

    public static double calculatePrice(int[] bookCountByBookType) {
        int[] bookPairsCount = new int[5];

        int differentBookCount = differentBookCounter(bookCountByBookType);
        while (differentBookCount > 0) {
            bookPairsCount[differentBookCount - 1]++;
            bookCountByBookType = fall(bookCountByBookType);
            differentBookCount = differentBookCounter(bookCountByBookType);
        }
        return calculatePriceWithDiscount(bookPairsCount);
    }

    private static double calculatePriceWithDiscount(int[] bookPairsCount) {
        return bookPairsCount[0] * BOOK_PRICE
                + bookPairsCount[1] * 2 * BOOK_PRICE * 0.95
                + bookPairsCount[2] * 3 * BOOK_PRICE * 0.9
                + bookPairsCount[3] * 4 * BOOK_PRICE * 0.8
                + bookPairsCount[4] * 5 * BOOK_PRICE * 0.75;
    }

    private static int differentBookCounter(int[] bookCountByBookType) {
        return (int) Arrays.stream(bookCountByBookType)
                .filter(c -> c > 0)
                .count();

    }

    //imagine books of similar types as balls in tubes. This function make the bottom line balls removed -> upper balls are falling down one level
    private static int[] fall(int[] bookCountByBookType) {
        int[] decreased = new int[bookCountByBookType.length];

        for (int i = 0; i < bookCountByBookType.length - 1; i++) {
            decreased[i] = --bookCountByBookType[i];
        }
        return decreased;
    }
}
