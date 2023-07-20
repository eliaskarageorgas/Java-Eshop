

public class CommonDetails {

    protected String productCode;
    protected String productModel;
    protected String productYear;
    protected String productManufacturer;
    protected float productPrice;
    protected String productCategory;  //Πρέπει να βάλουμε και μία μεταβλητή που θα αναφέρεται στον τύπο της συσκευής
                                      //(τηλεόραση, ψυγείο κ.λπ.). Επειδή το χαρακτηριστικό αυτό είναι κοινό για όλες
                                     //τις συσκευές το βάζουμε στο συγκεκριμένο class.
    protected int productStock; //Μεταβλητή που περιέχει τα διαθέσιμα κομμάτια για κάθε προϊόν.

    public CommonDetails(){

    }

    public CommonDetails(String productCode, String productModel, String productYear, String productManufacturer,
                         float productPrice, String productCategory, int productStock) {
        this.productCode = productCode;
        this.productModel = productModel;
        this.productYear = productYear;
        this.productManufacturer = productManufacturer;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productStock = productStock;
    }

    public String getProductCode() {

        return productCode;
    }

    public String getProductModel() {

        return productModel;
    }

    public String getProductYear() {

        return productYear;
    }

    public String getProductManufacturer() {

        return productManufacturer;
    }

    public float getProductPrice() {

        return productPrice;
    }

    public String getProductCategory() {

        return productCategory;
    }

    public int getProductStock() {

        return productStock;
    }

    //Θα φτιάξουμε set methods για όλες τις μεταβλητές ώστε σε περίπτωση που το κατάστημα θελήσει να αλλάξει
    // κάποιο χαρακτηριστικό του προϊόντος (πχ επειδή υπάρχει λάθος ή επειδή πρόκειται να γίνει αλλαγή
    // στην τιμή) να μπορεί να πραγματοποιηθεί η ενημέρωση.

    public void setProductCode(String newProductCode) {

        productCode = newProductCode;
    }

    public void setProductModel(String newProductModel) {

        productModel = newProductModel;
    }

    public void setProductYear(String newProductYear) {

        productYear = newProductYear;
    }

    public void setProductManufacturer(String newProductManufacturer) {

        productManufacturer = newProductManufacturer;
    }

    public void setProductPrice(float newProductPrice) {

        productPrice = newProductPrice;
    }

    public void setProductCategory(String newProductCategory) {

        productCategory = newProductCategory;
    }

    public void setProductStock(int newProductStock) {

        productStock = newProductStock;
    }
}
