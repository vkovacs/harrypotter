import java.util.Arrays;

/**
 * Imagine similar type of books as balls in separate vertical tubes.
 * First we register the quantity of the bottom line of balls and then remove them.
 * We do this until we run out of balls.
 * When we have the discounts chosen by the greedy algorithm above, we weight it by using creating discounts of 4 different types of books instead of discounts of 5 or 3 different kind of books
 * Calculate the price by using these discounts
 * */
class HarryPotter {
    private static final int BOOK_PRICE = 8;

    static double calculatePrice(int[] bookCountByBookType) {
        int[] discountTypeCount = new int[5];

        int differentBookTypesCountInBottomRow = countDifferentBookTypes(bookCountByBookType);
        while (differentBookTypesCountInBottomRow > 0) {
            discountTypeCount[differentBookTypesCountInBottomRow - 1]++;
            bookCountByBookType = fall(bookCountByBookType);
            differentBookTypesCountInBottomRow = countDifferentBookTypes(bookCountByBookType);
        }
        int[] weightedDiscountTypesCount = weightDiscountTypesCount(discountTypeCount);
        return calculatePriceWithDiscount(weightedDiscountTypesCount);
    }

    private static double calculatePriceWithDiscount(int[] weightedBookPairsCount) {
        return weightedBookPairsCount[0] * BOOK_PRICE
                + weightedBookPairsCount[1] * 2 * BOOK_PRICE * 0.95
                + weightedBookPairsCount[2] * 3 * BOOK_PRICE * 0.9
                + weightedBookPairsCount[3] * 4 * BOOK_PRICE * 0.8
                + weightedBookPairsCount[4] * 5 * BOOK_PRICE * 0.75;
    }

    private static int[] weightDiscountTypesCount(int[] bookPairsCount) {
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

    private static int[] fall(int[] bookCountByBookType) {
        return Arrays.stream(bookCountByBookType)
                .map(c -> c - 1)
                .toArray();
    }
}