import java.util.Scanner;
public class Main{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        int messageCounter = 1;
        boolean running = true;

        while (running){
            System.out.println("1. Send Message");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if(choice==1){
                System.out.print("Enter number:");
                String number = scanner.nextLine();

                System.out.print("Enter message:");
                String message = scanner.nextLine();

                Message msg = new Message(message, number, messageCounter);

                System.out.println("Message from " + username + " sent to " + msg.messageText);
                messageCounter++;
            } else {
                running = false;
            }
        }
        scanner.close();
    }
}