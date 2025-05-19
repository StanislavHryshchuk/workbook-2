package week_5.CarDealership;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminInterface {
    private Scanner scanner = new Scanner(System.in);
    private List<Contract> contracts = ContractFileManager.getListOfContracts();
    UserInterface us = new UserInterface();
    public void adminMenu(String password){

        if (password.equals("pass")){
           displayAdminInterface();
        } else {
            System.out.println("Wrong password please try again");
        }
    }
    public void displayAdminInterface() {

        boolean running = true;
        while (running) {
            System.out.println("\n     *** Home Screen *** ");
            System.out.println("Please select a menu option from 1 - 4 | 0 -> Exit");
            System.out.println("""
                    1. Show all contracts.
                    2. Show contracts by type.
                    3. Find a contract by Vehicle.
                    0. Exit.""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        ContractFileManager.displayAllContracts();
                        break;
                    case 2:
                        displayContract(getContractsByType(contracts));
                        break;
                    case 3:
                        displayContract(getContractsByVehicleVIN(contracts));
                        break;
                    case 0:
                        running = false;
                        us.userMenu();
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayContract (List<Contract> contracts){
        for(Contract contract: contracts){
            if(contract instanceof SalesContract){
                System.out.println(contract.toFileString());
            }else if (contract instanceof LeaseContract){
                System.out.println(contract.toFileString());
            }
        }
    }

    public List<Contract> getContractsByType(List<Contract> contracts){

        System.out.println("What type of contract you would like to see: Sale or Lease");
        String adminContractType = scanner.nextLine().trim().replaceAll("\\s{2,}"," ");

        List<Contract> contractsByType = new ArrayList<>();
        for(Contract contract: contracts){
            if(contract.getTypeOfContract().equalsIgnoreCase(adminContractType)){
                contractsByType.add(contract);
            }
        }
        return contractsByType;
    }

    public List<Contract> getContractsByVehicleVIN(List<Contract> contracts){

        System.out.println("Please enter the Vehicle VIN");
        String adminVin = scanner.nextLine().trim().replaceAll("\\s{2,}"," ");

        List<Contract> contractsVehicleVIN = new ArrayList<>();
        for(Contract contract: contracts){
            if(contract.getVehicle().getVinNumber().equalsIgnoreCase(adminVin)){
                contractsVehicleVIN.add(contract);
            }
        }
        return contractsVehicleVIN;
    }


}
