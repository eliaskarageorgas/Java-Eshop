

public class EnergyClass extends Type {

    protected String energyClass;

    public EnergyClass(){

    }

    public EnergyClass(String energyClass, String type, String productCode, String productModel, String productYear,
                       String productManufacturer, float productPrice, String productCategory, int productStock) {

        super(type, productCode, productModel, productYear, productManufacturer, productPrice, productCategory,
                productStock);
        this.energyClass = energyClass;
    }

    public String getEnergyClass() {

        return energyClass;
    }

    public void setEnergyClass(String newEnergyClass) {

        energyClass = newEnergyClass;
    }
}
