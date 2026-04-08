import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Message> messages = new ArrayList<>();

        System.out.print("Enter username:");
        String username = scanner.nextLine();

    

        boolean running = true;
        int messageCounter =1;

        while(running){
            System.out.print("Enter choice (1 to send, 2 to view, other to exit):");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice ==1){
                System.out.print("Enter number:");
                String number = scanner.nextLine();

                System.out.print("Enter message:");
                String text = scanner.nextLine();

                if(number.length() !=10){
                  System.out.println("Invalid number Must be 10 digits.");  

                }else if (text.length() > 250) {
                    System.out.println("Message is too long. Please limit to 250 characters.");
                
                }else{

                Message message = new Message(text, number, messageCounter);
                messages.add(message);

                System.out.println("Message sent!");
                System.out.println("Total messages sent: " + messages.size());

                messageCounter++;

                }


            } else if (choice == 2) {
                if (messages.isEmpty()) {
                    System.out.println("No messages to display.");
                } else {

                    System.out.println("Total messages sent: " + messages.size());
                    
                    for (Message m : messages) {
                        System.out.println("ID:" + m.messageId + "|From:" + username + "|To:" + m.recipientNumber + "|Message:" + m.messageText);
                    }
                }
            }else {
                System.out.println("Total.messages sent: " + messages.size());
                System.out.println("Goodbye!");
                running = false;
            }
        }

        scanner.close();

    }

}
        