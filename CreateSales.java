import java.util.ArrayList;
import java.io.*;

public class CreateSales {
    
    public void CreateSalesFile(ArrayList<SaleObject> saledProducts) {
        
        System.out.println("------------------------------------");
        System.out.println("Writing data from SaledProducts list to Sales txt File ");

        FileWriter writer;

        try {
            writer = new FileWriter(new File("SaledProducts.txt"));
            writer.write("SALES_LIST"+"\n"+"{");

            for (SaleObject i: saledProducts) {
                
                writer.write("\n"+"\t"+"SALE "+"\n"+"\t"+"{"+"\n"+"\t"+"CATEGORY "+ i.getProductCategory()
                + "\n"+"\t"+"MODEL "+ i.getProductModel()
                + "\n"+"\t"+"MANUFACTURER "+ i.getProductManufacturer()
                + "\n"+"\t"+"SALE_NUMBER "+ i.getSaleCode()
                + "\n"+"\t"+"NAME "+ i.getNameSurname()
                + "\n"+"\t"+"PHONE_NUMBER "+ i.getCustomerPhoneNumber()
                + "\n"+"\t"+"DATE "+ i.getDateOfSale()
                + "\n"+"\t"+"PIECES "+ i.getNumberOfPiecesSold()
                + "\n"+"\t"+"FINAL_PRICE "+ i.getFinalPrice() * i.getNumberOfPiecesSold()
                + "\n"+"\t"+"}");
            }
            writer.write("\n" + "}");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error while writing file.");
        }
    }
}