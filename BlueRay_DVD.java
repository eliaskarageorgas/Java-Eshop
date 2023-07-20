

public class BlueRay_DVD extends Resolution {

    private String Br_DvdFormat;

    public BlueRay_DVD(){

    }

    public BlueRay_DVD(String Br_DvdFormat, String resolution, String type, String productCode,
                       String productModel, String productYear, String productManufacturer, float productPrice,
                       String productCategory, int productStock) {

        super(resolution, type, productCode, productModel, productYear, productManufacturer, productPrice,
                productCategory, productStock);
        this.Br_DvdFormat = Br_DvdFormat;
    }

    public String getBr_DvdFormat() {

        return Br_DvdFormat;
    }

    public void setBr_DvdFormat(String newBr_DvdFormat) {

        Br_DvdFormat = newBr_DvdFormat;
    }

    public String toString() {

        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nType: " + type +
                "\nResolution: " + resolution +
                "\nFormat: " + Br_DvdFormat;
    }
}
