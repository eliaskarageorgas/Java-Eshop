
//Αριθμός Ομάδας: 33
//Αριθμοί μητρώου: 3190069, 3190073

import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {

        String homeSelection; //Μεταβλητή που αντιστοιχεί στην επιλογή του χρήστη στο αρχικό μενού.
        String categorySelection; //Μεταβλητή που αντιστοιχεί στην επιλογή του χρήστη στο μενού με τις κατηγορίες των συσκευών.
        String typeSelection; //Μεταβλητή που αντιστοιχεί στην επιλογή του χρήστη στο μενού με τους τύπους των προϊόντων.
        String orderSelection; //Μεταβλητή που αντιστοιχεί στην επιλογή του χρήστη στο μενού των παραγγελιών.
        String arrivedOrderSale;
        //Μεταβλητή που αντιστοιχεί στην επιλογή του χρήστη στο μενού που αποφασίζει αν θα εκτελεστεί η παραγγελία του.
        String exitMessage;

        ArrayList<String> orders = new ArrayList<>(); //Λίστα που περιέχει τους αριθμούς των παραγγελιών.
        System.out.println("------------------------------------");
        System.out.println("Temporary codes refer to the place of a specific product/sale/order in the file.");
        System.out.println("For example: The third product in the AvailableProducts.txt has product code 3.");
        ArrayList<CommonDetails> availableProducts = AvailableProducts.availableProductsFromTxt();
        //Λίστα που περιέχει τα object που δημιούργηθηκαν παραπάνω.
        ArrayList<SaleObject> saledProducts = SaledProducts.saledProductsFromTxt(availableProducts); //Λίστα που περιέχει τα προϊόντα που πουλήθηκαν.
        ArrayList<OrderObject> orderedProducts = OrderedProducts.OrderedProductsFromTxt(availableProducts);
        //Λίστα που περιέχει τα προϊόντα για τα οποία έχει γίνει παραγγελία.
        Scanner input = new Scanner(System.in);

        while (true) {
            SaleOrOrder obj1 = new SaleOrOrder(false);
            /*Φτιάχνω object της SaleOrOrder (το οποίο χρησιμοποιώ μετά για την διαδικασία της πώλησης/παραγγελίας) και ορίζω
            την backToHomePage ως false, γίνεται true στην περίπτωση που πραγματοποιηθεί παραγγελία ή πώληση.
            Διαβάζω όπου χρειάζεται η backToHomePage με την μέθοδο obj1.getBackToHomeObject.*/
            System.out.println("------------------------------------");
            System.out.println("1. Show available products \n" +
                               "2. Sale list \n" +
                               "3. Order list\n" +
                               "4. Exit shop");
            System.out.print("Choose category (1-4): ");
            homeSelection = input.next();
            if (!homeSelection.equals("1") && !homeSelection.equals("2") && !homeSelection.equals("3") &&
                    !homeSelection.equals("4")) { //Έλεγχος εγκυρότητας για τις αρχικές επιλογές.
                System.out.println("------------------------------------");
                System.out.println("Wrong selection. Please try again ");
            } else if (homeSelection.equals("2")) {
                int i;
                /* Ορίζω απ' έξω το i για να έχω πρόσβαση και εκτός επανάληψης, ώστε στην περίπτωση που είναι κενή η
                 λίστα να βρίσκει οτι το i παρέμεινε 0 και να εμφανίζει ότι η λίστα είναι κενή.*/
                System.out.println("------------------------------------");
                for(i = 0; i < saledProducts.size(); i++) {
                    System.out.println(saledProducts.get(i));
                }
                if (i == 0){ System.out.println("There are no sales.");}
                System.out.println("Returning to home page.");
            } else if (homeSelection.equals("3")) {
                while (true) {
                    if (obj1.getBackToHomePage()){ //Η μεταβλητή γίνεται true μόνο όταν πραγματοποιείται μια πώληση.
                        break;
                    }
                    System.out.println("------------------------------------");
                    int i; //Αντίστοιχα με τις πωλήσεις στην προηγούμενη περίπτωση.
                    orders.clear(); //Αδειάζουμε τη λίστα ώστε να "διαγράφονται" οι προηγούμενες παραγγελίες.
                    for (i = 0; i < orderedProducts.size(); i++) {
                        orders.add(String.valueOf(i+1));  /*Για κάθε παραγγελία που υπάρχει στον κατάλογο τον παραγγελιών,
                                                         προσσθέτουμε στη λίστα τον αντίστοιχο αριθμό.*/
                        System.out.println((i + 1) + ". Customer's name: " + orderedProducts.get(i).getNameSurname() +
                                "\n   Order's code: " + orderedProducts.get(i).getOrderCode() +
                                "\n   Order status: " + orderedProducts.get(i).getOrderStatus());
                    }
                    orders.add(String.valueOf(i+1)); //Προσθέτουμε στη λίστα τον αριθμό που αντιστοιχεί στην επιλογή "Back".
                    if (i == 0) {
                        System.out.println("There are no orders.");
                        System.out.println("Returning to home page.");
                        break;
                    } else {
                        System.out.println((orderedProducts.size() + 1) + ". Back");
                        System.out.print("Select an order or type " +
                                (orderedProducts.size() + 1) + " to return to home page: ");
                        orderSelection = input.next();
                        if (!orders.contains(orderSelection)) {
                            System.out.println("------------------------------------");
                            System.out.println("Wrong selection. Please try again ");
                        }else if (Integer.parseInt(orderSelection) == orderedProducts.size() + 1) {
                            break;
                        }else {
                            while (true){
                                if (obj1.getBackToHomePage()){ //Η μεταβλητή γίνεται true μόνο όταν εκτελεστεί μια παραγγελία.
                                    break;
                                }
                                System.out.println("------------------------------------");
                                System.out.print("1. Order arrival and sale\n" +
                                        "2. Back\n" +
                                        "Type 1 or 2: ");
                                arrivedOrderSale = input.next();
                                if (arrivedOrderSale.equals("1") &&
                                        orderedProducts.get(Integer.parseInt(orderSelection) - 1).getOrderStatus().equals("Is expected")) {
                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).setOrderStatus("Completed");
                                    SaleObject obj =
                                            new SaleObject(orderedProducts.get(Integer.parseInt(orderSelection) - 1).getProductModel(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getProductManufacturer(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getFinalPrice(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getProductCategory(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getNameSurname(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getCustomerPhoneNumber(),
                                                    orderedProducts.get(Integer.parseInt(orderSelection) - 1).getNumberOfPiecesSold());
                                    saledProducts.add(obj); //Προσθέτει το προιόν που παραλήφθηκε στον κατάλογο των πωλήσεων.
                                    obj.setFinalPrice(orderedProducts.get(Integer.parseInt(orderSelection) - 1).getFinalPrice());
                                    /* Ορίζουμε την τελική τιμή του προιόντος ίση με την τελική τιμή που είχε υπολογιστεί όταν παραγγέλθηκε
                                    ωστε να μην εφαρμοστεί δεύτερη φορά η εκπτωση.*/
                                    System.out.println("The order is completed");
                                    obj1.setBackToHomePage(true);
                                } else if (arrivedOrderSale.equals("1") &&
                                        orderedProducts.get(Integer.parseInt(orderSelection) - 1).getOrderStatus().equals("Completed")) {
                                    System.out.println("The order is completed. Returning to home page.");
                                } else if (arrivedOrderSale.equals("2")) {
                                    break;
                                } else {
                                    System.out.println("------------------------------------");
                                    System.out.println("Wrong selection.Please try again ");
                                }
                            }
                        }
                    }
                }
            } else if (homeSelection.equals("4")) {
                while (true){
                    System.out.println("------------------------------------");
                    System.out.println("Do you want to exit? \n" +
                            "1. Yes \n" +
                            "2. No");
                    System.out.print("Please choose between 1 or 2: ");
                    exitMessage = input.next();
                    if (!exitMessage.equals("1") && !exitMessage.equals("2")){
                        System.out.println("------------------------------------");
                        System.out.println("Wrong selection. Please type again ");
                    } else if (exitMessage.equals("1")){
                        CreateOrders ordersCreation = new CreateOrders();
                        ordersCreation.CreateOrdersFile(orderedProducts);//Εγγραφή των παραγγελιών που έγιναν
                        CreateSales salesCreation = new CreateSales();
                        salesCreation.CreateSalesFile(saledProducts);//Εγγραφή των πωλήσεων που έγιναν
                        System.out.println("------------------------------------");
                        System.out.println("Have a nice day");
                        break;
                    } else {
                        System.out.println("------------------------------------");
                        System.out.println("Returning to home page");
                        break;
                    }
                }
                if (exitMessage.equals("1")){
                    break;}
            } else {
                while (true) {
                    if (obj1.getBackToHomePage()){ //Η μεταβλητή γίνεται true μόνο όταν πραγματοποιείται μια πώληση/παραγγελία.
                        break;
                    }
                    System.out.println("------------------------------------");
                    System.out.println("1. Sound And Image \n" +
                            "2. Gaming \n" +
                            "3. Household appliances \n" +
                            "4. Back");
                    System.out.print("Please choose category: ");
                    categorySelection = input.next();
                    if (!categorySelection.equals("1") && !categorySelection.equals("2") &&
                            !categorySelection.equals("3") && !categorySelection.equals("4")) {
                        //'Ελεγχος εγκυρότητας για την επιλογή κατηγορίας.
                        System.out.println("------------------------------------");
                        System.out.println("Wrong selection. Please try again ");
                    } else if (categorySelection.equals("2")) {
                        while (true) {
                            if (obj1.getBackToHomePage()){ //Η μεταβλητή γίνεται true μόνο όταν πραγματοποιείται μια πώληση/παραγγελία
                                break;
                            }
                            System.out.println("------------------------------------");
                            System.out.println("1. Consoles / Portable consoles \n" +
                                    "2. Back");
                            System.out.print("Please choose product's type: ");
                            typeSelection = input.next();
                            if (typeSelection.equals("1")){
                                obj1.SaleOrOrderMethod(availableProducts,"Game Console",
                                        saledProducts, orderedProducts, input);
                            } else if(typeSelection.equals("2")){
                                break;
                            } else {
                                System.out.println("------------------------------------");
                                System.out.println("Wrong selection. Please try again ");
                            }
                        }
                    } else if (categorySelection.equals("3")) {
                        while (true){
                            if (obj1.getBackToHomePage()) { //Η μεταβλητή γίνεται true μόνο όταν πραγματοποιείται μια πώληση/παραγγελία.
                                break;
                            }
                            System.out.println("------------------------------------");
                            System.out.println("1. Fridges \n" +
                                    "2. Washing Machine \n" +
                                    "3. Back");
                            System.out.print("Please choose product's type: ");
                            typeSelection = input.next();
                            if (typeSelection.equals("1")) {
                                obj1.SaleOrOrderMethod(availableProducts,"Fridge",
                                        saledProducts, orderedProducts, input);
                            } else if (typeSelection.equals("2")) {
                                obj1.SaleOrOrderMethod(availableProducts,"Washing Machine",
                                        saledProducts, orderedProducts, input);
                            } else if (typeSelection.equals("3")) {
                                break;
                            } else {
                                System.out.println("------------------------------------");
                                System.out.println("Wrong selection. Please try again ");
                            }
                        }
                    } else if (categorySelection.equals("4")) {
                        break;
                        //Έτσι τελειώνει την επανάληψη αυτή και ξεκινάει ξανά τον έλεγχο εγκυρότητας αρχικών επιλογών.
                    } else {
                        while(true){ //Έλεγχος εγκυρότητας για την επιλογή τύπου
                            if (obj1.getBackToHomePage()){ //Η μεταβλητή γίνεται true μόνο όταν πραγματοποιείται μια πώληση/παραγγελία.
                                break;
                            }
                            System.out.println("------------------------------------");
                            System.out.println("1. TVs \n" +
                                    "2. Blue Ray/DVD players \n" +
                                    "3. Cameras \n" +
                                    "4. Back");
                            System.out.print("Please choose product's type: ");
                            typeSelection = input.next();
                            if (typeSelection.equals("1")) {
                                obj1.SaleOrOrderMethod(availableProducts,"TV",
                                        saledProducts, orderedProducts, input);
                            } else if (typeSelection.equals("2")) {
                                obj1.SaleOrOrderMethod(availableProducts,"BlueRay/DVD",
                                        saledProducts, orderedProducts, input);
                            } else if(typeSelection.equals("3")) {
                                obj1.SaleOrOrderMethod(availableProducts,"Camera",
                                        saledProducts, orderedProducts, input);
                            } else if (typeSelection.equals("4")) {
                                break;
                            } else {
                                System.out.println("------------------------------------");
                                System.out.println("Wrong selection. Please try again ");
                            }
                        }
                    }
                }
            }
        }
    }
}