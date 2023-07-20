import java.util.ArrayList;
import java.io.*;

public class SaledProducts{
    public static ArrayList<SaleObject> saledProductsFromTxt(ArrayList<CommonDetails> availableProducts){
        
        boolean productIsOnAvailableProducts;
        ArrayList<SaleObject> saledProducts = new ArrayList<>();
        BufferedReader reader;
		SaleObject product;
        String line;
        boolean numberFormatCheck;
        int productNumber = 0;
        System.out.println("------------------------------------");
		System.out.println("Adding Products from SaledProducts txt File to SaledProducts List ");
        try {
			reader = new BufferedReader(new FileReader(new File("SaledProducts.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equals("sale") || line.trim().equals("SALE")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        product = new SaleObject();
                        productNumber += 1;
                        product.setProductCategory("Not given");
                        product.setProductModel("Not given");
                        product.setProductManufacturer("Not given");
                        product.setSaleCode("Not given");
                        product.setNameSurname("Not given");
                        product.setCustomerPhoneNumber("Not given");
                        product.setDateOfSale("Not given");
                        product.setNumberOfPiecesSold(0);
                        product.setFinalPrice(0);
                        numberFormatCheck = false;
                        productIsOnAvailableProducts = false;
                        while(true) {
                            line = reader.readLine();
                            if (line.trim().startsWith("category ") || line.trim().startsWith("CATEGORY"))
                                product.setProductCategory(line.trim().substring(9).trim());
                            else if (line.trim().startsWith("model ") || line.trim().startsWith("MODEL "))
                                product.setProductModel(line.trim().substring(6).trim());
                            else if (line.trim().startsWith("manufacturer ") || line.trim().startsWith("MANUFACTURER "))
                                product.setProductManufacturer(line.trim().substring(13).trim());
                            else if (line.trim().startsWith("sale_number ") || line.trim().startsWith("SALE_NUMBER "))
                                product.setSaleCode(line.trim().substring(12).trim());
                            else if (line.trim().startsWith("name ") || line.trim().startsWith("NAME "))
                                product.setNameSurname(line.trim().substring(5).trim());
                            else if (line.trim().startsWith("phone_number ") || line.trim().startsWith("PHONE_NUMBER "))
                                product.setCustomerPhoneNumber(line.trim().substring(13).trim());
                            else if (line.trim().startsWith("date ") || line.trim().startsWith("DATE "))
                                product.setDateOfSale(line.trim().substring(5).trim());
                            else if (line.trim().startsWith("pieces ") || line.trim().startsWith("PIECES ")) {
                                try{
                                    product.setNumberOfPiecesSold(Integer.parseInt(line.trim().substring(7).trim()));
                                }
                                catch (final NumberFormatException check) {
                                    //Έλεγχος εγκυρότητας σε περίπτωση που δίνεται γράμμα στην ποσότητα που αγοράστηκε
                                    System.out.println	("Wrong value for pieces sold was given for product with temporary sale code " + productNumber);
                                    System.out.println("This product will not be in the saled products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                                if (product.getNumberOfPiecesSold() <= 0){
                                    //Έλεγχος εγκυρότητας σε περίπτωση που δίνεται αρνητική τιμή
                                    numberFormatCheck = true;
                                    System.out.println	("Wrong value for pieces sold was given for product with temporary sale code " + productNumber);
                                    System.out.println("This product will not be in the saled products list");
                                    break;
                                }
                            } else if (line.trim().startsWith("final_price ") || line.trim().startsWith("FINAL_PRICE ")) {
                                try {
                                    product.setFinalPrice(Float.parseFloat(line.trim().substring(12).trim()));
                                }
                                catch (final NumberFormatException check) {
                                    //Έλεγχος εγκυρότητας σε περίπτωση που δίνεται γράμμα στην τελική τιμή 
                                    System.out.println	("Wrong value for final price was given for product with temporary sale code " + productNumber);
                                    System.out.println("This product will not be in the saled products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                                if (product.getFinalPrice() <= 0){
                                    //Έλεγχος εγκυρότητας σε περίπτωση που δίνεται αρνητική τιμή
                                    numberFormatCheck = true;
                                    System.out.println	("Wrong value for final price was given for product with temporary sale code " + productNumber);
                                    System.out.println("This product will not be in the saled products list");
                                    break;
                                }
                            }else if (line.trim().equals("}")){
                                break;    
                            }  
                        }
                        if (numberFormatCheck)
                            continue;
                        else if (product.getSaleCode().equals("Not given")) {
                            System.out.println("The sale number of the product with temporary sale code " + productNumber + " was not given.");
                            System.out.println("This product will not be in the saled products list.");
                        } else {
                            for(int i = 0; i < availableProducts.size(); i++ ) { 
                                // Έλεγχει αν το προιόν που αναφέρεται στη λίστα παραγγελιών υπάρχει και στη λίστα διαθέσιμων
                                if (product.getProductCategory().equals(availableProducts.get(i).getProductCategory())) {
                                    if (product.getProductModel().equals(availableProducts.get(i).getProductModel())) {
                                        if (product.getProductManufacturer().equals(availableProducts.get(i).getProductManufacturer()))
                                            productIsOnAvailableProducts = true;
                                    }
                                }
                            }
                            if (productIsOnAvailableProducts) {
                                saledProducts.add(product);
                            } else {
                                System.out.println("An unvalid product was given");
                            }
                        }       
                    } //SALE
                } //PRODUCT
			line = reader.readLine();
		} //while
		reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
        return saledProducts;
	} // ReadFile
}