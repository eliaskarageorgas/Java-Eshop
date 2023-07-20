import java.util.ArrayList;
import java.io.*;

public class CreateOrders {
    
    public void CreateOrdersFile(ArrayList<OrderObject> orderedProducts) {
        
        System.out.println("------------------------------------");
        System.out.println("Writing data from OrderedProducts list to Orders txt File ");

        FileWriter writer;

        try {
            writer = new FileWriter(new File("OrderedProducts.txt"));
            writer.write("ORDER_LIST"+"\n"+"{");

            for (OrderObject i: orderedProducts) {

                writer.write("\n"+"\t"+"ORDER "+"\n"+"\t"+"{"+"\n"+"\t"+"CATEGORY "+ i.getProductCategory()
                + "\n"+"\t"+"MODEL "+ i.getProductModel()
                + "\n"+"\t"+"MANUFACTURER "+ i.getProductManufacturer()
                + "\n"+"\t"+"ORDER_NUMBER "+ i.getOrderCode()
                + "\n"+"\t"+"NAME "+ i.getNameSurname()
                + "\n"+"\t"+"PHONE_NUMBER "+ i.getCustomerPhoneNumber()
                + "\n"+"\t"+"DATE "+ i.getDateOfOrder()
                + "\n"+"\t"+"STATUS "+ i.getOrderStatus()
                + "\n"+"\t"+"PRODUCT_ARRIVAL "+ i.getExpectedDaysToArrive()
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
