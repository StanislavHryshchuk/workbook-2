package week_5.CarDealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    public static String CONTRACT_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\contracts.csv";

    public static <T extends Contract> void writeContractToFile(T contract){
        try (FileWriter fr = new FileWriter(CONTRACT_FILENAME,true)){
            fr.write(contract.toFileString() + "\n");
        }catch (IOException e){
            System.out.println("Failed to write to file" +  e.getMessage());
        }
    }

    public static void displayAllContracts(){
        try (BufferedReader br = new BufferedReader(new FileReader(CONTRACT_FILENAME))) {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static  List<Contract> getListOfContracts(){
        List<Contract> contracts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CONTRACT_FILENAME))){
            String line;
            while ((line = br.readLine()) != null){
                String[] arrContractInfo = line.split("\\|");
                if(arrContractInfo.length == 15){
                    LeaseContract leaseContract = new LeaseContract(
                            arrContractInfo[0],
                            arrContractInfo[1],
                            arrContractInfo[2],
                            arrContractInfo[3],
                            new Vehicle(
                                    arrContractInfo[4],
                                    Integer.parseInt(arrContractInfo[5]),
                                    arrContractInfo[6],
                                    arrContractInfo[7],
                                    arrContractInfo[8],
                                    arrContractInfo[9],
                                    Double.parseDouble(arrContractInfo[10]),
                                    Double.parseDouble(arrContractInfo[11])),
                            Double.parseDouble(arrContractInfo[12]) ,
                            Double.parseDouble(arrContractInfo[13]),
                             Double.parseDouble(arrContractInfo[14]));

                    contracts.add(leaseContract);

                } else if (arrContractInfo.length == 18) {
                    SalesContract salesContract = new SalesContract(
                            arrContractInfo[0],
                            arrContractInfo[1],
                            arrContractInfo[2],
                            arrContractInfo[3],
                                    new Vehicle(
                                    arrContractInfo[4],
                                    Integer.parseInt(arrContractInfo[5]),
                                    arrContractInfo[6],
                                    arrContractInfo[7],
                                    arrContractInfo[8],
                                    arrContractInfo[9],
                                    Double.parseDouble(arrContractInfo[10]),
                                    Double.parseDouble(arrContractInfo[11])),
                            Double.parseDouble(arrContractInfo[12]),
                            Double.parseDouble(arrContractInfo[13]),
                            Double.parseDouble(arrContractInfo[14]),
                            arrContractInfo[16],
                            Double.parseDouble(arrContractInfo[17])
                            );

                    contracts.add(salesContract);
                } else {
                    System.out.println("No lines, matching for a contract");
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return contracts;
    }
}