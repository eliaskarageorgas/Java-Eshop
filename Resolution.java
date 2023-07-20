
public class Resolution extends Type {

    protected String resolution;

    public Resolution(){

    }

    public Resolution(String resolution, String type, String productCode, String productModel, String productYear,
                      String productManufacturer, float productPrice, String productCategory, int productStock) {

        super(type, productCode, productModel, productYear, productManufacturer, productPrice, productCategory,
                productStock);
        this.resolution = resolution;
    }

    public String getResolution() {

        return resolution;
    }

    public void setResolution(String newResolution) {

        resolution = newResolution;
    }
}
