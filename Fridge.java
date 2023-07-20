

public class Fridge extends EnergyClass {

    private String fridgeCooler;
    private String fridgeFreezer;

    public Fridge(){

    }

    public Fridge(String fridgeCooler, String fridgeFreezer, String energyClass, String type,
                  String productCode, String productModel, String productYear, String productManufacturer,
                  float productPrice, String productCategory, int productStock) {

        super(energyClass, type, productCode, productModel, productYear, productManufacturer, productPrice,
                productCategory, productStock);
        this.fridgeCooler = fridgeCooler;
        this.fridgeFreezer = fridgeFreezer;
    }

    public String getFridgeCooler() {

        return fridgeCooler;
    }

    public String getFridgeFreezer() {

        return  fridgeFreezer;
    }

    public void setFridgeCooler(String newFridgeCooler) {

        fridgeCooler = newFridgeCooler;
    }

    public void setFridgeFreezer(String newFridgeFreezer) {

        fridgeFreezer = newFridgeFreezer;
    }

    public String toString() {

        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nType: " + type +
                "\nEnergy class: " + energyClass +
                "\nRefrigerator capacity: " + fridgeCooler +
                "\nFreezer capacity: " + fridgeFreezer;
    }
}
