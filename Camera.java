

public class Camera extends Type {

    private String camMp;
    private String camOpticalZoom;
    private String camDigitalZoom;
    private String camDisplay;


    public Camera(){

    }

    public Camera(String camMp, String camOpticalZoom, String camDigitalZoom, String camDisplay, String type,
                  String productCode, String productModel, String productYear, String productManufacturer,
                  float productPrice, String productCategory, int productStock) {

        super(type, productCode, productModel, productYear, productManufacturer, productPrice, productCategory,
                productStock);
        this.camMp = camMp;
        this.camOpticalZoom = camOpticalZoom;
        this.camDigitalZoom = camDigitalZoom;
        this.camDisplay = camDisplay;
    }

    public String getCamMp() {

        return camMp;
    }

    public String getCamOpticalZoom() {

        return camOpticalZoom;
    }

    public String getCamDigitalZoom() {

        return camDigitalZoom;
    }

    public String getCamDisplay() {

        return camDisplay;
    }

    public void setCamMp(String newCamMp) {

        camMp = newCamMp;
    }

    public void setCamOpticalZoom(String newCamOpticalZoom) {

        camOpticalZoom = newCamOpticalZoom;
    }

    public void setCamDigitalZoom(String newCamDigitalZoom) {

        camDigitalZoom = newCamDigitalZoom;
    }

    public void setCamDisplay(String newCamDisplay) {

        camDisplay = newCamDisplay;
    }

    public String toString() {

        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nType: " + type +
                "\nMegapixels: " + camMp +
                "\nOptical Zoom: " + camOpticalZoom +
                "\nDigital Zoom: " + camDigitalZoom +
                "\nDisplay dimensions: " + camDisplay;
    }
}
