import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to MessagingApp1!");
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        boolean running =true;
        while (running){
            System.out.println("\nMenu - " + username);
            System.out.println("1. Save message");
            System.out.println("2. Receive messages");
            System.out.println("3. Delete message");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice =scanner.nextInt();
            scanner.nextLine();// Consume newLine();

            switch(choice){
                case 1:
                    System.out.print("Enter the message to save: ");
                    break;
                case 2:
                    System.out.println("View messages selected.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        

        scanner.close();
    }
}