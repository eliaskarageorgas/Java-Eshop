
import java.util.ArrayList;
import java.util.Scanner;

public class SaleOrOrder {
    private boolean backToHomePage;

    public SaleOrOrder(boolean backToHomePage) {
        this.backToHomePage = backToHomePage;
    }

    public void SaleOrOrderMethod(ArrayList<CommonDetails> availableProducts, String type,
                       ArrayList<SaleObject> saledProducts, ArrayList<OrderObject> orderedProducts, Scanner input) {
        String productSelection;
        String numberOfPiecesCustomerWants;
        String saleOrOrderSelection = "1";
        /*Θεωρούμε ότι ο καταναλωτής πληκτρολογεί τον αριθμό που αντιστοιχεί στην επιλογή της αγοράς/παραγγελίας.Αυτό το κάνουμε
        ώστε να μπορέσουμε να χρησιμοποιήσουμε τη μεταβλητή saleOrOrderSelection σε παρακάτω συνθήκη (γραμμή 41), προτού πάρει
        τιμή από τον χρήστη.*/
        int counter;
        String str;
        int counter2 = 0;
        ArrayList<CommonDetails> productsOfSameType = new ArrayList<>();
        counter = 0; //Μεταβλητή για να μετράει τα στοιχεία με ίδιο τύπο και να εμφανίζει τις δυνατές επιλογές του χρήστη.
        System.out.println("----------------------------------");
        for (CommonDetails product : availableProducts) {
            if (product.getProductCategory().equals(type)) {
                counter += 1;
                System.out.println((counter) + ". " + product.getProductManufacturer() +
                        " " + product.getProductModel());
                productsOfSameType.add(product); //Δημιουργείται λίστα με τα μοντέλα ίδιου τύπου.
            }
        }
        while (true) {
            if (backToHomePage){ /*Αν πραγματοποιήθηκε πώληση ή παραγγελία (η backToHomePage έγινε true) σταματάει τον έλεγχο
            εγκυρότητας (πριν εμφανίστει κάτι στον χρήστη) ώστε να επιστρέψει στην προηγούμενη επανάληψη στην mainApp.*/
                break;
            }
            counter = 0;
            for (CommonDetails availableProduct : availableProducts) {
                if (availableProduct.getProductCategory().equals(type) && (saleOrOrderSelection.equals("2") ||
                        counter2 == (productsOfSameType.size() + 1))) {
                    /*Στο συγκεκριμένο if θα "μπει" μόνο αν επιλέξει να επιστρέψει στα διαθέσιμα προϊόντα της κατηγορίας αυτής ή
                    δώσει λάθος δεδομένα.*/
                    counter += 1;
                    System.out.println((counter) + ". " + availableProduct.getProductManufacturer() +
                            " " + availableProduct.getProductModel());
                }
            }
            System.out.println((productsOfSameType.size() + 1) + ". Back ");
            System.out.print("Choose product or type " + (productsOfSameType.size() + 1) +
                             " to return to product selection page: ");
            counter2 = 0; //Μηδενίζουμε ξανά τον counter2 για να ξαναρχίσει να μετράει αν δώσει 2η φορά λάθος δεδομένα.
            productSelection = input.next();
            System.out.println("----------------------------------");
            for (int i = 1; i <= productsOfSameType.size() + 1; i++) { //Ελέγχουμε αν υπάρχει η επιλογή του χρήστη.
                str = Integer.toString(i);
                if (!productSelection.equals(str)) {
                    counter2 += 1; /*Αν το input που μόλις έδωσε ο χρήστης δεν αντιστοιχεί με τον δείκτη του προϊόντος,
                     θα αυξάνουμε τον counter2 κατά 1.*/
                }
            }
            if (counter2 == (productsOfSameType.size() + 1)) { /*Αν ο counter2 ισούται με το πλήθος των διαθέσιμων προϊόντων
             + 1 (για την επιλογή πίσω), τότε σημαίνει ότι το input δεν αντιστοιχεί σε κάποια από τις διαθέσιμες επιλογές.
             Δηλαδή έδωσε λάθος δεδομένα.*/
                System.out.println("Wrong selection. Please try again.");
                System.out.println("----------------------------------");
            } else if (Integer.parseInt(productSelection) == productsOfSameType.size() + 1) {
                break;
            } else {
                System.out.println(productsOfSameType.get(Integer.parseInt(productSelection) - 1));
                if (productsOfSameType.get(Integer.parseInt(productSelection) - 1).productStock > 0) {
                    //Ελέγχει αν υπάρχει απόθεμα.
                    while (true) {
                        System.out.println("----------------------------------");
                        System.out.print( "1. Sale\n" +
                                "2. Back\n" +
                                "Type 1 or 2: ");
                        saleOrOrderSelection = input.next();
                        if (saleOrOrderSelection.equals("1")) {
                            while (true){ // Έλεγχος εγκυρότητας για την ποσότητα που ζητάει ο πελάτης
                                System.out.println("----------------------------------");
                                System.out.println("There are "+ productsOfSameType.get(Integer.parseInt(productSelection) - 1).productStock
                                        +" pieces of this product in stock");
                                System.out.println("In case you want more pieces of this product, you can buy the ones we already have " +
                                        "and order the rest. We will keep them for you and you can take them when the ordered ones arrive.");
                                System.out.print("Type how many pieces you want or 0 to go back to product selection: ");
                                numberOfPiecesCustomerWants= input.next();
                                boolean thereIsEnoughStock = false; // Μεταβλητή που γίνεται true αν η ποσότητα που ζητάει ο πελάτης υπάρχει
                                for (int i = 1; i <= productsOfSameType.get(Integer.parseInt(productSelection) - 1).productStock; i++ ){
                                    if (String.valueOf(i).equals(numberOfPiecesCustomerWants)){
                                        thereIsEnoughStock=true;
                                        break;
                                    }
                                }
                                if (numberOfPiecesCustomerWants.equals("0")) {
                                    break;
                                }else if (!thereIsEnoughStock ){
                                    System.out.println("----------------------------------");
                                    System.out.println("You selected more pieces than our stock or you typed something wrong.");
                                    System.out.println("Please try again.");
                                } else {
                                    break;
                                }
                            }
                            if (numberOfPiecesCustomerWants.equals("0")) {
                                counter2 = (productsOfSameType.size() + 1);
                                /*Επειδή μεταφέρουμε τον χρήστη "δύο βήματα (μενού) πίσω, θεωρούμε ότι στη επιλογή
                                 Πώληση/Παραγγελία ή Πίσω" επέλεξε να πατήσει "Πίσω". Οπότε δίνουμε στο counter2 την τιμή
                                 της επιλογής αυτής ώστε να μπει στο if της γραμμής 41 και να εμφανίσει ξανά τα διαθέσιμα προϊόντα.*/
                                System.out.println("----------------------------------");
                                break;
                            }
                            backToHomePage = true; //Πραγματοποιείται πώληση οπότε την ορίζουμε true για να επιστρέψει στην αρχική σελίδα.
                            System.out.println("The final price is: "
                                    +FinalPriceCalculator.Sales(productsOfSameType.get(Integer.parseInt(productSelection) - 1).productPrice,
                                    productsOfSameType.get(Integer.parseInt(productSelection) - 1).productCategory) *
                                    Integer.parseInt(numberOfPiecesCustomerWants)
                                    + " Euros ");
                                    /*Καλέσαμε την FinalPriceCalculator για τον υπολογισμό της τελικής τιμής και
                                    την πολλαπλασιάσαμε με την ποσότητα που επιθυμεί ο χρήστης*/
                            System.out.print("Type name and surname (in english): ");
                            String nameSurname = input.next();
                            System.out.print("Type telephone number: ");
                            String customerPhoneNumber = input.next();
                            System.out.println("----------------------------------");
                            System.out.println("The sale was succesful. Returning to home page.");
                            SaleObject obj1 =
                                    new SaleObject(productsOfSameType.get(Integer.parseInt(productSelection) - 1).productModel,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productManufacturer,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productPrice,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productCategory,
                                            nameSurname, customerPhoneNumber,Integer.parseInt(numberOfPiecesCustomerWants));
                            saledProducts.add(obj1);
                            for (CommonDetails availableProduct : availableProducts) {
                                /*Βρίσκει το προιόν που πουλήθηκε στη λίστα με τα διαθέσιμα
                                προιόντα και μειώνει το απόθεμά του κατά 1.*/
                                if (availableProduct.productCode.equals(productsOfSameType.get(Integer.parseInt(productSelection) - 1).productCode)) {
                                    availableProduct.productStock -= Integer.parseInt(numberOfPiecesCustomerWants);
                                }
                            }
                            break;
                        } else if(saleOrOrderSelection.equals("2")) {
                            System.out.println("----------------------------------");
                            break;
                        } else {
                            System.out.println("----------------------------------");
                            System.out.println("Wrong selection. Please try again.");
                        }
                    }
                } else {
                    while (true) {
                        System.out.println("----------------------------------");
                        System.out.println("This product isn't available right now so you can order it.");
                        System.out.println("1. Order \n" +
                                        "2. Back");
                        System.out.print("Type 1 or 2: ");
                        saleOrOrderSelection = input.next();
                        if (saleOrOrderSelection.equals("1")) {
                            while (true){ // Έλεγχος εγκυρότητας για την ποσότητα που ζητάει ο πελάτης
                                System.out.println("----------------------------------");
                                System.out.println("You can order from 1 to 50 pieces of this product");
                                System.out.println("In case you want more pieces of this product, you will have to make multiple orders.");
                                System.out.print("Type how many pieces you want or 0 to go back to product selection: ");
                                numberOfPiecesCustomerWants= input.next();
                                boolean thereIsEnoughStock = false; // Μεταβλητή που γίνεται true αν η ποσότητα που ζητάει ο πελάτης είναι έγγυρη για παραγγελία
                                for (int i = 1; i <= 50; i++ ){
                                    if (String.valueOf(i).equals(numberOfPiecesCustomerWants)){
                                        thereIsEnoughStock=true;
                                        break;
                                    }
                                }
                                if (numberOfPiecesCustomerWants.equals("0")){
                                    break;
                                }else if (!thereIsEnoughStock ){
                                    System.out.println("----------------------------------");
                                    System.out.println("You selected more than 50 pieces or you typed something wrong.");
                                    System.out.println("Please try again. ");
                                } else {
                                    break;
                                }
                            }
                            if (numberOfPiecesCustomerWants.equals("0")) {
                                counter2 = (productsOfSameType.size() + 1);
                                /*Επειδή μεταφέρουμε τον χρήστη "δύο βήματα (μενού) πίσω, θεωρούμε ότι στη επιλογή
                                 Πώληση/Παραγγελία ή Πίσω" επέλεξε να πατήσει "Πίσω". Οπότε δίνουμε στο counter2 την τιμή
                                 της επιλογής αυτής ώστε να μπει στο if της γραμμής 41 και να εμφανίσει ξανά τα διαθέσιμα προϊόντα.*/
                                System.out.println("----------------------------------");
                                break;
                            }
                            backToHomePage = true; //Πραγματοποιείται παραγγελία οπότε την ορίζουμε true για να επιστρέψει στην αρχική σελίδα.
                            System.out.println("The final price is: "
                                    +FinalPriceCalculator.Sales(productsOfSameType.get(Integer.parseInt(productSelection) - 1).productPrice,
                                    productsOfSameType.get(Integer.parseInt(productSelection) - 1).productCategory) *
                                    Integer.parseInt(numberOfPiecesCustomerWants)
                                    + " Euros ");
                                    /*Καλέσαμε την FinalPriceCalculator για τον υπολογισμό της τελικής τιμής και
                                    την πολλαπλασιάσαμε με την ποσότητα που επιθυμεί ο χρήστης*/
                            System.out.print("Type name and surname (in english): ");
                            String nameSurname = input.next();
                            System.out.print("Type telephone number: ");
                            String customerPhoneNumber = input.next();
                            System.out.println("----------------------------------");
                            System.out.println("The order was successful. Returning to home page.");
                            OrderObject obj2 =
                                    new OrderObject(productsOfSameType.get(Integer.parseInt(productSelection) - 1).productModel,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productManufacturer,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productPrice,
                                            productsOfSameType.get(Integer.parseInt(productSelection) - 1).productCategory,
                                            nameSurname, customerPhoneNumber, 5,
                                            Integer.parseInt(numberOfPiecesCustomerWants));
                            orderedProducts.add(obj2);
                            break;
                        } else if(saleOrOrderSelection.equals("2")) {
                            System.out.println("----------------------------------");
                            break;
                        } else {
                            System.out.println("----------------------------------");
                            System.out.println("Wrong selection. Please try again.");
                        }
                    }
                }
            }
        }
    }
    public  boolean getBackToHomePage() {
        return backToHomePage;
    }

    public void setBackToHomePage(boolean backToHomePage) {
        this.backToHomePage = backToHomePage;
    }
}