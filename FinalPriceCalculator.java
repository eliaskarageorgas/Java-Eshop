

public class FinalPriceCalculator {
    public static float Sales(float price, String category) {
        float finalPrice;
        if (category.equals("TV") || category.equals("BlueRay/DVD") || category.equals("Camera")) {
            finalPrice = price - (price * 25 / 100);
        } else if (category.equals("Game Console")) {
            finalPrice = price - (price * 10 / 100);
        } else {
            finalPrice = price - (price * 20 / 100);
        }
        return finalPrice;
    }
}
