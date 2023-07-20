

//Φτιάχνουμε ξεχωριστό class για το χαρακτηριστικό "τύπος", επειδή χρησιμοποιείται στα 5 από τα 6 είδη συσκευών.
//Με αυτόν τον τρόπο αποφεύγουμε την επανάληψη ίδιου κώδικα.
public class Type extends CommonDetails {
    protected String type;

    public Type(){

    }

    public Type(String type, String productCode, String productModel, String productYear, String productManufacturer,
                float productPrice, String productCategory, int productStock) {

        super(productCode, productModel, productYear, productManufacturer, productPrice, productCategory, productStock);
        this.type = type;
    }

    public String getType() {

        return type;
    }

    public void setType(String newType) {

        type = newType;
    }
}
