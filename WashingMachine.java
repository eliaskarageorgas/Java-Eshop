

public class WashingMachine extends EnergyClass {

    private String washCapacity;
    private String washRotations;

    public WashingMachine(){

    }

    public WashingMachine(String washCapacity, String washRotations, String energyClass, String type,
                          String productCode, String productModel, String productYear, String productManufacturer,
                          float productPrice, String productCategory, int productStock) {

        super(energyClass, type, productCode, productModel, productYear, productManufacturer, productPrice,
                productCategory, productStock);
        this.washCapacity = washCapacity;
        this.washRotations = washRotations;
    }

    public String getWashCapacity() {

        return washCapacity;
    }

    public String getWashRotations() {

        return washRotations;
    }

    public void setWashCapacity(String newWashCapacity) {

        washCapacity = newWashCapacity;
    }

    public void setWashRotations(String newWashRotations) {

        washRotations = newWashRotations;
    }

    public String toString() {

        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nEnergy class: " + energyClass +
                "\nCapacity: " + washCapacity +
                "\nRounds per minute: " + washRotations;
    }
}
