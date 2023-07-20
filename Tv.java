

public class Tv extends Resolution {

    private String tvDimensions;
    private String tvPorts;

    public Tv(){

    }

    public Tv(String tvDimensions, String tvPorts, String resolution, String type, String productCode,
              String productModel, String productYear, String productManufacturer, float productPrice,
                String productCategory, int productStock) {

        super(resolution, type, productCode, productModel, productYear, productManufacturer, productPrice,
                productCategory, productStock);
        this.tvDimensions = tvDimensions;
        this.tvPorts = tvPorts;
    }

    public String getTvDimensions() {

        return tvDimensions;
    }

    public String getTvPorts() {

        return tvPorts;
    }

    public void setTvDimensions(String newTvDimensions) {

        tvDimensions = newTvDimensions;
    }

    public void setTvPorts(String newTvPorts) {

        tvPorts = newTvPorts;
    }

    public String toString() {
        
        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nType: " + type +
                "\nDimensions: " + tvDimensions +
                "\nResolution: " + resolution +
                "\nAvailable ports: " + tvPorts;
    }
}