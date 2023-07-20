import java.util.ArrayList;
import java.io.*;

public class AvailableProducts{
    public static ArrayList<CommonDetails> availableProductsFromTxt(){
		
        ArrayList<CommonDetails> availableProducts = new ArrayList<>();
        BufferedReader reader = null;
		CommonDetails product = null;
        String line;
        boolean numberFormatCheck;
        int productNumber = 0;
        System.out.println("------------------------------------");
		System.out.println("Adding Products from AvailableProducts txt File to AvailableProducts List ");
        try {
			reader = new BufferedReader(new FileReader(new File("AvailableProducts.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equals("ITEM") || line.trim().equals("item")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        productNumber+= 1;
                        String category = "Not given";
                        String code = "Not given";
                        String model = "Not given";
                        String year = "Not given";
                        String manufacturer = "Not given";
                        float price = 0f;
                        String type = "Not given";
                        String tvDimensions = "Not given";
                        String tvOrBlueRayResolution= "Not given";
                        String brDvdFormat = "Not given";
                        String tvPorts = "Not given";
                        String camMp = "Not given";
                        String camOpticalZoom = "Not given";
                        String camDigitalZoom = "Not given";
                        String camDisplay = "Not given";
                        String consoleCpu = "Not given";
                        String consoleGraphics = "Not given";
                        String consoleSound = "Not given";
                        String consoleHdd = "Not given";
                        String fridgeColler = "Not given";
                        String fridgeFreezer = "Not given";
                        String energyClass = "Not given";
                        String washCapacity = "Not given";
                        String washRotations = "Not given";
                        int stock = 0;
                        numberFormatCheck = false;
                        while(true){ //Διαβάσμα txt 
                            line = reader.readLine();
                            if (line.trim().startsWith("category ") || line.trim().startsWith("CATEGORY "))
                                category = line.trim().substring(9).trim();
                            else if (line.trim().startsWith("code ") || line.trim().startsWith("CODE "))
                                code = line.trim().substring(5).trim();
                            else if (line.trim().startsWith("model ") || line.trim().startsWith("MODEL "))
                                model = line.trim().substring(6).trim();
                            else if (line.trim().startsWith("year ") || line.trim().startsWith("YEAR "))
                                year = line.trim().substring(5).trim();
                            else if (line.trim().startsWith("manufacturer ") || line.trim().startsWith("MANUFACTURER "))
                                manufacturer = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("price ") || line.trim().startsWith("PRICE ")){
                                try{
                                    price = Float.parseFloat(line.trim().substring(6).trim());
                                }
                                catch (final NumberFormatException check) {//Έλεγχος εγκυρότητας σε περίπτωση που δίνεται γράμμα στην τιμή προιόντος
                                    System.out.println	("Wrong value for price was given for product with temporary product code " + productNumber);
                                    System.out.println("This product will not be in the available products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                                if (price <= 0){
                                    System.out.println	("Wrong value for price was given for product with temporary product code " + productNumber);
                                    System.out.println("This product will not be in the available products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                            }else if (line.trim().startsWith("type ") || line.trim().startsWith("TYPE "))
                                type = line.trim().substring(5).trim();
                            else if (line.trim().startsWith("tv_dimensions ") || line.trim().startsWith("TV_DIMENSIONS "))
                                tvDimensions = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("resolution ") || line.trim().startsWith("RESOLUTION "))
                                tvOrBlueRayResolution = line.trim().substring(11).trim();
                            else if (line.trim().startsWith("tv_ports ") || line.trim().startsWith("TV_PORTS "))
                                tvPorts = line.trim().substring(8).trim();
                            else if (line.trim().startsWith("br_dvd_format ") || line.trim().startsWith("BR_DVD_FORMAT"))
                                brDvdFormat = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("cam_mp ") || line.trim().startsWith("CAM_MP "))
                                camMp = line.trim().substring(6).trim();
                            else if (line.trim().startsWith("cam_optical_zoom ") || line.trim().startsWith("CAM_OPTICAL_ZOOM "))
                                camOpticalZoom = line.trim().substring(15).trim();
                            else if (line.trim().startsWith("cam_digital_zoom ") || line.trim().startsWith("CAM_DIGITAL_ZOOM "))
                                camDigitalZoom = line.trim().substring(15).trim();
                            else if (line.trim().startsWith("cam_display ") || line.trim().startsWith("CAM_DISPLAY "))
                                camDisplay = line.trim().substring(11).trim();
                            else if (line.trim().startsWith("console_cpu ") || line.trim().startsWith("CONSOLE_CPU "))
                                consoleCpu = line.trim().substring(11).trim();
                            else if (line.trim().startsWith("console_graphics ") || line.trim().startsWith("CONSOLE_GRAPHICS "))
                                consoleGraphics = line.trim().substring(16).trim();
                            else if (line.trim().startsWith("console_sound ") || line.trim().startsWith("CONSOLE_SOUND "))
                                consoleSound = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("console_hdd ") || line.trim().startsWith("CONSOLE_HDD "))
                                consoleHdd = line.trim().substring(11).trim();
                            else if (line.trim().startsWith("fridge_cooler ") || line.trim().startsWith("FRIDGE_COOLER "))
                                fridgeColler = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("fridge_freezer ") || line.trim().startsWith("FRIDGE_FREEZER "))
                                fridgeFreezer = line.trim().substring(14).trim();
                            else if (line.trim().startsWith("energy_class ") || line.trim().startsWith("ENERGY_CLASS "))
                                energyClass = line.trim().substring(12).trim();
                            else if (line.trim().startsWith("wash_capacity ") || line.trim().startsWith("WASH_CAPACITY "))
                                washCapacity = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("wash_rotation ") || line.trim().startsWith("WASH_ROTATION "))
                                washRotations = line.trim().substring(13).trim();
                            else if (line.trim().startsWith("pieces ") || line.trim().startsWith("PIECES ")){
                                try{
                                    stock = Integer.parseInt(line.trim().substring(7).trim());
                                }
                                catch (final NumberFormatException check) {//Έλεγχος εγκυρότητας σε περίπτωση που δίνεται γράμμα στο απόθεμα προιόντος
                                    System.out.println	("Wrong value for stock was given for product with temporary product code " + productNumber);
                                    System.out.println("This product will not be in the available products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                                if (stock < 0){
                                    System.out.println	("Wrong value for stock was given for product with temporary product code " + productNumber);
                                    System.out.println("This product will not be in the available products list");
                                    numberFormatCheck = true;
                                    break;
                                }
                            }else if (line.trim().equals("}"))
                                break;
                        }
                        if (numberFormatCheck){
                            /*Έλεγχος αν δόθηκε λάθος δεδομένο σε τιμή ή απόθεμα προιόντος ώστε
                            να συνεχιστεί το διάβασμα του txt αρχείου και απλά να παραληφθεί το
                            συγκεκριμένο προιόν*/ 
                            continue;
                        }else if (category.equals("Not given")){
                            System.out.println("Category of product with temporary product code "+ productNumber +" was not given.");
                            System.out.println("This product will not be in the available products list");
                        }else if (code.equals("Not given")){
                            System.out.println("Code of product with temporary product code "+ productNumber +" was not given.");
                            System.out.println("This product will not be in the available products list");
                        }else if (model.equals("Not given")){
                            System.out.println("Model of product with temporary product code "+ productNumber +" was not given.");
                            System.out.println("This product will not be in the available products list");
                        }else{ //Αντιστοίχηση τιμών που διαβάστηκαν στο προιόν 
                            if(category.equals("TV")){
                                product = new Tv();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((Tv)product).setType(type);
                                ((Tv)product).setTvDimensions(tvDimensions);
                                ((Tv)product).setResolution(tvOrBlueRayResolution);
                                ((Tv)product).setTvPorts(tvPorts);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else if(category.equals("BlueRay/DVD")){
                                product = new BlueRay_DVD();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((BlueRay_DVD)product).setType(type);
                                ((BlueRay_DVD)product).setResolution(tvOrBlueRayResolution);
                                ((BlueRay_DVD)product).setBr_DvdFormat(brDvdFormat);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else if(category.equals("Camera")){
                                product = new Camera();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((Camera)product).setType(type);
                                ((Camera)product).setCamMp(camMp);
                                ((Camera)product).setCamOpticalZoom(camOpticalZoom);
                                ((Camera)product).setCamDigitalZoom(camDigitalZoom);
                                ((Camera)product).setCamDisplay(camDisplay);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else if(category.equals("Game Console")){
                                product = new Console();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((Console)product).setType(type);
                                ((Console)product).setConsoleCpu(consoleCpu);
                                ((Console)product).setConsoleGraphics(consoleGraphics);
                                ((Console)product).setConsoleSound(consoleSound);
                                ((Console)product).setConsoleHdd(consoleHdd);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else if(category.equals("Fridge")){
                                product = new Fridge();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((Fridge)product).setType(type);
                                ((Fridge)product).setFridgeCooler(fridgeColler);
                                ((Fridge)product).setFridgeFreezer(fridgeFreezer);
                                ((Fridge)product).setEnergyClass(energyClass);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else if(category.equals("Washing Machine")){
                                product = new WashingMachine();
                                product.setProductCategory(category);
                                product.setProductCode(code);
                                product.setProductModel(model);
                                product.setProductYear(year);
                                product.setProductManufacturer(manufacturer);
                                product.setProductPrice(price);
                                ((WashingMachine)product).setType(type);
                                ((WashingMachine)product).setWashCapacity(washCapacity);
                                ((WashingMachine)product).setWashRotations(washRotations);
                                ((WashingMachine)product).setEnergyClass(energyClass);
                                product.setProductStock(stock);
                                availableProducts.add(product);
                            }else {
                                System.out.println("Category of product with temporary product code " + productNumber + " was given wrong.");
                            }
                        }
                    } //Item
                
                } //Product
				line = reader.readLine();
				
			} //while
			reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
        }
        return availableProducts;
	} // ReadFile
}