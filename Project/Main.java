package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartQueue smartQueue = new SmartQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nSmartQueue Menu:");
                System.out.println("1. Add Regular Customer");
                System.out.println("2. Add VIP Customer");
                System.out.println("3. Add Senior Customer");
                System.out.println("4. Call Next Customer");
                System.out.println("5. Display Queue Status");
                System.out.println("6. Exit");

                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addCustomer(smartQueue, "Regular", scanner);
                    case 2 -> addCustomer(smartQueue, "VIP", scanner);
                    case 3 -> addCustomer(smartQueue, "Senior", scanner);
                    case 4 -> {
                        Customer nextCustomer = smartQueue.callNext();
                        System.out.println("Next Customer: " + nextCustomer.getName() + " (Token: " + nextCustomer.getTokenNumber() + ")");
                    }
                    case 5 -> smartQueue.displayQueueStatus();
                    case 6 -> {
                        System.out.println("Exiting SmartQueue. Have a great day!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please select a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void addCustomer(SmartQueue smartQueue, String type, Scanner scanner) {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            int token = smartQueue.generateToken();
            Customer customer;

            switch (type) {
                case "Regular" -> customer = new RegularCustomer(name, token);
                case "VIP" -> customer = new VIPCustomer(name, token);
                case "Senior" -> customer = new SeniorCustomer(name, token);
                default -> throw new IllegalArgumentException("Invalid customer type.");
            }

            smartQueue.addCustomer(customer);
            System.out.println(type + " Customer added with token: " + token);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error while adding customer: " + e.getMessage());
        }
    }
}
