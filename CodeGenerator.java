

public class CodeGenerator {
    /*Σε αυτό το class δημιουργούνται οι κωδικοί παραγγελιών και πωλήσεων
   Οι κωδικοί είναι με αύξουσα σειρά και υποθέτουμε οτι εχούν πέντε ψηφεία */
    private static int productCount = 0;
    private static int orderCount = 0;
    private static int saleCount = 0;

    public  static String OrderCode(){
        orderCount++;
        String str1 = "";
        for (int i = 0 ; i< 4 -Integer.toString(orderCount).length(); i++){
            str1 = str1.concat("0");
            // Δημιουργούμε 4ψήφιο κωδικό οπότε με αυτή την επανάληψη προσθέτουμε αν χρειάζονται μηδενικά στην αρχή του
        }
        return "O"+ str1 + orderCount;
        // Δημιουργεί πενταψήφιο κωδικό με Ο μπροστά από το Order για να ξεχωρίζουμε ότι είναι κωδικός παραγγελίας
    }

    public static String SaleCode() {
        saleCount++;
        String str1 = "";
        for (int i = 0; i < 4 - Integer.toString(saleCount).length(); i++) {
            str1 = str1.concat("0");
        }
        return "S" + str1 + saleCount;
        // Δημιουργεί πενταψήφιο κωδικό με S μπροστά από το Sale για να ξεχωρίζουμε ότι είναι κωδικός πώλησης
    }
    public static String ProductCode() {
        productCount++;
        String str1 = "";
        for (int i = 0; i < 4 - Integer.toString(productCount).length(); i++) {
            str1 = str1.concat("0");
        }
        return "P" + str1 + productCount;
        // Δημιουργεί πενταψήφιο κωδικό με P μπροστά από το Product για να ξεχωρίζουμε ότι είναι κωδικός προιόντος
    }
}
