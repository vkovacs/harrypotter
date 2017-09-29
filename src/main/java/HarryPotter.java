public class HarryPotter {
    public static double calculatePrice(int[] books) {
        int differentBookCount = books.length;

        double basePrice = differentBookCount * 8;

        if (differentBookCount == 1) {
            return basePrice;
        }  else {
            return basePrice * 0.95;
        }
    }
}
