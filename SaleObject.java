
import java.time.LocalDate; //Δίνει την ημερομηνία την στιγμή που καλείται το class.

public class SaleObject {

    private String saleCode = CodeGenerator.SaleCode();
    private String nameSurname;
    private String customerPhoneNumber;
    LocalDate obj1 = LocalDate.now(); //Δημιουργείται object του class LocalDate το οποίο επιστρέφει την ημερομηνία.
    private String dateOfSale = obj1.toString(); //Μετατρέπεται το object σε String.
    private float finalPrice;
    private String productModel;
    private int numberOfPiecesSold;
    private String productManufacturer;
    private String productCategory;

    public SaleObject(){
    }

    public SaleObject(String productModel, String productManufacturer, float price, String productCategory,
                      String nameSurname, String customerPhoneNumber, int numberOfPiecesSold) {
        this.productManufacturer = productManufacturer;
        this.productModel = productModel;
        this.nameSurname = nameSurname;
        this.customerPhoneNumber = customerPhoneNumber;
        this.finalPrice = FinalPriceCalculator.Sales(price, productCategory);
        this.numberOfPiecesSold = numberOfPiecesSold;
        this.productCategory = productCategory;
    }

    public String getSaleCode() {return saleCode;}
    public String getNameSurname() {return nameSurname;}
    public String getCustomerPhoneNumber() {return customerPhoneNumber;}
    public String getDateOfSale() {return dateOfSale;}
    public float getFinalPrice() {return finalPrice;}
    public String getProductModel() {return productModel;}
    public String getProductManufacturer() {return productManufacturer;}
    public int getNumberOfPiecesSold() {return numberOfPiecesSold;}
    public String getProductCategory() {return productCategory;}

    public void setSaleCode(String saleCode) {this.saleCode = saleCode;}
    public void setNameSurname(String nameSurname) {this.nameSurname = nameSurname;}
    public void setCustomerPhoneNumber(String customerPhoneNumber) {this.customerPhoneNumber = customerPhoneNumber;}
    public void setFinalPrice(float finalPrice) {this.finalPrice = finalPrice;}
    public void setDateOfSale(String dateOfSale) {this.dateOfSale = dateOfSale;}
    public void setProductModel(String productModel) { this.productModel = productModel;}
    public void setProductManufacturer(String productManufacturer) { this.productManufacturer=productManufacturer;}
    public void setNumberOfPiecesSold(int numberOfPiecesSold){this.numberOfPiecesSold= numberOfPiecesSold;}
    public void setProductCategory(String productCategory){this.productCategory = productCategory;}

    public String toString() {
        return "Sale code is: " + saleCode + "\n"
                + "Product sold: " + productManufacturer + " " + productModel + "\n"
                + "Date of sale: " + dateOfSale + "\n"
                + "Customer's name and surname: " + nameSurname + "\n"
                + "Customer's telephone number: " + customerPhoneNumber + "\n"
                + "Product's final price is: " + finalPrice + "\n"
                + "The amount of pieces bought was: " + numberOfPiecesSold +"\n"
                + "The total cost of the sale was: " + numberOfPiecesSold*finalPrice +"\n";
    }
}
