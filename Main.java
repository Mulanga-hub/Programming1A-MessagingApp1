import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Message> messages = new ArrayList<>();

        int messageCounter = 1;
        boolean running = true;

        while(running){
            System.out.println("\n1.Send Message");
            System.out.println("2.View Messages");
            System.out.println("3.Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice ==1){
                System.out.print("Enter number:");
                String number = scanner.nextLine();

                System.out.print("Enter message:");
                String text = scanner.nextLine();

                Message message = new Message(text, number, messageCounter++);
                messages.add(message);

                System.out.println("Message sent");

                messageCounter++;

                }else if(choice == 2){
                    for (Message m : messages){
                        System.out.println("Id: " + m.messageId + "|To:" + m.recipientNumber + "| Message:" +m.messageText);
                    }


            }else if(choice == 3){
                running = false;
            }
      
         }

         scanner.close();
    }
}