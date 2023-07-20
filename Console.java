

public class Console extends Type {

    private String consoleCpu;
    private String consoleGraphics;
    private String consoleSound;
    private String consoleHdd;

    public Console(){

    }

    public Console(String consoleCpu, String consoleGraphics, String consoleSound, String consoleHdd, String type,
                   String productCode, String productModel, String productYear, String productManufacturer,
                   float productPrice, String productCategory, int productStock) {

        super(type, productCode, productModel, productYear, productManufacturer, productPrice, productCategory,
                productStock);
        this.consoleCpu = consoleCpu;
        this.consoleGraphics = consoleGraphics;
        this.consoleSound = consoleSound;
        this.consoleHdd = consoleHdd;
    }

    public String getConsoleCpu() {

        return consoleCpu;
    }

    public String getConsoleGraphics() {

        return consoleGraphics;
    }

    public String getConsoleSound() {

        return consoleSound;
    }

    public String getConsoleHdd() {

        return consoleHdd;
    }

    public void setConsoleCpu(String newConsoleCpu) {

        consoleCpu = newConsoleCpu;
    }

    public void setConsoleGraphics(String newConsoleGraphics) {

        consoleGraphics = newConsoleGraphics;
    }

    public void setConsoleSound(String newConsoleSound) {

        consoleSound = newConsoleSound;
    }

    public void setConsoleHdd(String newConsoleHdd) {

        consoleHdd = newConsoleHdd;
    }

    public String toString() {

        return "Product's code: " + productCode +
                "\nProduct's model: " + productModel +
                "\nYear of production: " + productYear +
                "\nBrand name: " + productManufacturer +
                "\nPrice before sales: " + productPrice +
                "\nPrice after sales: " + FinalPriceCalculator.Sales(productPrice, productCategory) +
                "\nType: " + type +
                "\nCPU: " + consoleCpu +
                "\nGPU: " + consoleGraphics +
                "\nSound capabilities: " + consoleSound +
                "\nHDD capacity: " + consoleHdd;
    }
}
