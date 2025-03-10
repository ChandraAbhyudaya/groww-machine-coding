import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Admin admin = new Admin("Moulesh");
        Employee employee = new Employee("Chandra");

        Map<String, Integer> itemsToAdd = new HashMap<>();
        itemsToAdd.put("Pepsi", 4);
        itemsToAdd.put("Lays", 10);
        itemsToAdd.put("Nachos", 20);

        Map<String, Double> itemPrices = new HashMap<>();
        itemPrices.put("Pepsi", 50.00);
        itemPrices.put("Lays", 25.00);
        itemPrices.put("Nachos", 100.00);

        admin.addItems(vendingMachine, itemsToAdd, itemPrices);
        employee.viewItems(vendingMachine);

        Map<String, Integer> itemsToPurchase = new HashMap<>();
        itemsToPurchase.put("Pepsi", 3);
        itemsToPurchase.put("Lays", 4);
        employee.purchaseItems(vendingMachine, itemsToPurchase);

        admin.toggleMachineState(vendingMachine);

        employee.viewItems(vendingMachine);


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Are you a(n) admin or employee");
//        String userType = scanner.nextLine().trim();
//
//        System.out.println("Enter your name : ");
//        String userName = scanner.nextLine().trim();
//
//        User user;
//        if (userType.equalsIgnoreCase("Admin")) {
//            user = new Admin(userName);
//        } else {
//            user = new Employee(userName);
//        }
//
//        boolean exit = false;
//        while (!exit) {
//            System.out.println("Choose an operation: ");
//            System.out.println("1. Add items(Admin only) ");
//            System.out.println("2. Purchase Items ");
//            System.out.println("3. View Items ");
//            System.out.println("4. Toggle Machine State(Admin only)");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    if (user instanceof Admin) {
//                        Map<String, Integer> itemsToAdd = new HashMap<>();
//                        Map<String, Double> itemPrices = new HashMap<>();
//                        System.out.println("Enter number of items to add: ");
//                        int numberOfItems = scanner.nextInt();
//                        for (int i = 0; i < numberOfItems; i++) {
//                            System.out.println("Enter item name: ");
//                            String itemName = scanner.nextLine();
//                            System.out.println("Enter quantity: ");
//                            int quantity = scanner.nextInt();
//                            System.out.println("Enter price: ");
//                            double price = scanner.nextDouble();
//                            scanner.nextLine();
//
//                            itemsToAdd.put(itemName, quantity);
//                            itemPrices.put(itemName, price);
//                        }
//                        ((Admin) user).addItems(vendingMachine, itemsToAdd, itemPrices);
//                    } else {
//                        System.out.println("Only admin can add items");
//                    }
//                    break;
//                case 2:
//                    Map<String, Integer> itemsToPurchase = new HashMap<>();
//                    System.out.println("Enter number of items to purchase: ");
//                    int numberOfItems = scanner.nextInt();
//                    for(int i = 0; i < numberOfItems; i++){
//                        System.out.println("Enter item name : ");
//                        String itemName = scanner.nextLine();
//                        System.out.println("Enter quantity : ");
//                        int quantity = scanner.nextInt();
//                        scanner.nextLine();
//                        itemsToPurchase.put(itemName, quantity);
//                    }
//                    user.purchaseItems(vendingMachine, itemsToPurchase);
//                    break;
//                case 3:
//                    user.viewItems(vendingMachine);
//                    break;
//                case 4:
//                    if(user instanceof Admin){
//                        ((Admin) user).toggleMachineState(vendingMachine);
//                    }
//                    else {
//                        System.out.println("Only admin can can change state of machine");
//                    }
//                    break;
//                case 5:
//                    exit = true;
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//        }
//        scanner.close();
//        System.out.println("Vending machine turning off");

    }
}