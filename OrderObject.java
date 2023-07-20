
import java.time.LocalDate; // Δίνει την ημερομηνία την στιγμή που καλείται το class


public class OrderObject {

    private String orderCode = CodeGenerator.OrderCode();
    private String nameSurname;
    private String customerPhoneNumber;
    LocalDate obj = LocalDate.now(); // Δημιουργείται object του class LocalDate το οποίο επιστρέφει την ημερομηνία
    private String dateOfOrder = obj.toString(); // Μετατρέπεται το object σε String
    private int expectedDaysToArrive;
    private float finalPrice;
    private String orderStatus = "Is expected";
    private String productModel;
    private String productManufacturer;
    private String productCategory;
    private int numberOfPiecesSold;

    public OrderObject(){
    }

    public OrderObject(String productModel,String productManufacturer,float price,
                       String category,String nameSurname, String customerPhoneNumber,int expectedDaysToArrive, int numberOfPiecesSold){
        this.productManufacturer= productManufacturer;
        this.productModel= productModel;
        this.nameSurname = nameSurname;
        this.customerPhoneNumber = customerPhoneNumber;
        this.expectedDaysToArrive = expectedDaysToArrive;
        this.productCategory= category;
        this.finalPrice = FinalPriceCalculator.Sales(price, category);
        this.numberOfPiecesSold = numberOfPiecesSold;
    }

    public String getOrderCode(){ return orderCode;}
    public String getNameSurname(){return nameSurname;}
    public String getCustomerPhoneNumber (){return customerPhoneNumber;}
    public String getDateOfOrder(){return dateOfOrder;}
    public String getOrderStatus(){return orderStatus;}
    public float getFinalPrice(){return finalPrice; }
    public int getExpectedDaysToArrive(){return expectedDaysToArrive;}
    public String getProductModel(){return productModel;}
    public String getProductManufacturer(){return productManufacturer;}
    public String getProductCategory(){return productCategory;}
    public int getNumberOfPiecesSold() {return numberOfPiecesSold;}


    public void setOrderCode(String orderCode){this.orderCode = orderCode;}
    public void setNameSurname(String nameSurname){this.nameSurname = nameSurname;}
    public void setCustomerPhoneNumber(String customerPhoneNumber){ this.customerPhoneNumber = customerPhoneNumber;}
    public void setOrderStatus(String orderStatus){this.orderStatus = orderStatus;}
    public void setFinalPrice(float finalPrice){this.finalPrice = finalPrice;}
    public void setExpectedDaysToArrive(int expectedDaysToArrive){this.expectedDaysToArrive = expectedDaysToArrive;}
    public void setDateOfOrder(String dateOfOrder){this.dateOfOrder = dateOfOrder;}
    public void setProductModel(String productModel) { this.productModel = productModel;}
    public void setProductManufacturer(String productManufacturer) { this.productManufacturer=productManufacturer;}
    public void setProductCategory(String productCategory) { this.productCategory=productCategory;}
    public void setNumberOfPiecesSold(int numberOfPiecesSold){this.numberOfPiecesSold= numberOfPiecesSold;}

    public String toString(){
        return "Order code is: "+ orderCode+ "\n"
                + "Product ordered: " + productManufacturer +" "+ productModel +"\n"
                + "Date of order: " + dateOfOrder + "\n"
                + "Customer's name and surname: "+ nameSurname + "\n"
                + "Customer's telephone number: " + customerPhoneNumber + "\n"
                + "Product's final price:  " + finalPrice + "\n"
                + "Order's status: " + orderStatus + "\n"
                + "This order is expected to arrive in " + expectedDaysToArrive + " days"+ "\n"
                + "The amount of pieces bought was: " + numberOfPiecesSold +"\n"
                + "The total cost of the order: " + numberOfPiecesSold*finalPrice +"\n";
    }
}