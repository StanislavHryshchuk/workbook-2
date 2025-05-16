package week_5.CarDealership;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public static String CONTRACT_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\contracts.csv";

    public static <T extends Contract> void writeContractToFile(T contract){
        try (FileWriter fr = new FileWriter(CONTRACT_FILENAME,true)){
            fr.write(contract.toFileString() + "\n");
        }catch (IOException e){
            System.out.println("Failed to write to file" +  e.getMessage());
        }
    }
}
