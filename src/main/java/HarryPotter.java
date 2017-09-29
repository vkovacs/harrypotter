import java.util.List;

public class HarryPotter {
    public static double calculatePrice(List<Integer> books) {

        int differentBookCount = books.size();

        double basePrice = differentBookCount * 8;
        double sum = 0;

        int allBookCount = books.stream().
                filter(i -> i > 0)
                .mapToInt(Integer::intValue)
                .sum();

        while (allBookCount > 0) {
            if (differentBookCount == 1) {
                sum += basePrice;
            } else if (differentBookCount == 2) {
                sum += basePrice * 0.95;
            }

            for (int i = 0; i < differentBookCount; i++) {
                if (books.get(i) == 1) {
                    books.remove(i);
                } else {
                    books.set(i, books.get(i) - 1);
                }
            }
        }
        return sum;
    }
}
