import java.util.Arrays;

public class HarryPotter {
    private static final int BOOK_PRICE = 8;

    public static double calculatePrice(int[] bookCountByBookType) {
        int[] bookPairsCount = new int[5];

        int differentBookTypeCount = countDifferentBookTypes(bookCountByBookType);
        while (differentBookTypeCount > 0) {
            bookPairsCount[differentBookTypeCount - 1]++;
            bookCountByBookType = fall(bookCountByBookType);
            differentBookTypeCount = countDifferentBookTypes(bookCountByBookType);
        }
        int[] weightedBookPairsCount = weightBookPairsCount(bookPairsCount);
        return calculatePriceWithDiscount(weightedBookPairsCount);
    }

    private static double calculatePriceWithDiscount(int[] weightedBookPairsCount) {
        return weightedBookPairsCount[0] * BOOK_PRICE
                + weightedBookPairsCount[1] * 2 * BOOK_PRICE * 0.95
                + weightedBookPairsCount[2] * 3 * BOOK_PRICE * 0.9
                + weightedBookPairsCount[3] * 4 * BOOK_PRICE * 0.8
                + weightedBookPairsCount[4] * 5 * BOOK_PRICE * 0.75;
    }

    private static int[] weightBookPairsCount(int[] bookPairsCount) {
        int[] weightedBookPairsCount = Arrays.copyOf(bookPairsCount, bookPairsCount.length);
        while (weightedBookPairsCount[2] > 0 && weightedBookPairsCount[4] > 0) {
            weightedBookPairsCount[2] -= 1;
            weightedBookPairsCount[4] -= 1;
            weightedBookPairsCount[3] += 2;
        }
        return weightedBookPairsCount;
    }

    private static int countDifferentBookTypes(int[] bookCountByBookType) {
        return (int) Arrays.stream(bookCountByBookType)
                .filter(c -> c > 0)
                .count();
    }

    //imagine books of similar types as balls in tubes. This function make the bottom line balls removed -> upper balls are falling down one level
    private static int[] fall(int[] bookCountByBookType) {
        int[] fallen = new int[bookCountByBookType.length];

        for (int i = 0; i < bookCountByBookType.length - 1; i++) {
            fallen[i] = --bookCountByBookType[i];
        }
        return fallen;
    }
}
