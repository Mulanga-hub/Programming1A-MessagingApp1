import java.io.*;
import java.util.*;

public class MessagingApp {
    private static final String MESSAGES_FILE = "messages.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMessaging App");
            System.out.println("1. Save message");
            System.out.println("2. Receive messages");
            System.out.println("3. Delete message");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine().trim();
                if (!message.isEmpty()) {
                    saveMessage(message);
                    System.out.println("Message saved!");
                } else {
                    System.out.println("Message cannot be empty.");
                }
            } else if (choice.equals("2")) {
                receiveMessages();
            } else if (choice.equals("3")) {
                System.out.print("Enter message number to delete: ");
                try {
                    int index = Integer.parseInt(scanner.nextLine().trim());
                    deleteMessage(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number.");
                }
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static List<String> loadMessages() {
        List<String> messages = new ArrayList<>();
        try {
            File file = new File(MESSAGES_FILE);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        messages.add(line);
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Error loading messages: " + e.getMessage());
        }
        return messages;
    }

    private static void saveMessages(List<String> messages) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(MESSAGES_FILE));
            for (String msg : messages) {
                writer.write(msg);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving messages: " + e.getMessage());
        }
    }

    private static void saveMessage(String message) {
        List<String> messages = loadMessages();
        messages.add(message);
        saveMessages(messages);
    }

    private static void receiveMessages() {
        List<String> messages = loadMessages();
        if (messages.isEmpty()) {
            System.out.println("No messages.");
            return;
        }
        System.out.println("Messages:");
        for (int i = 0; i < messages.size(); i++) {
            System.out.println((i + 1) + ". " + messages.get(i));
        }
    }

    private static void deleteMessage(int index) {
        List<String> messages = loadMessages();
        if (index >= 1 && index <= messages.size()) {
            String deleted = messages.remove(index - 1);
            saveMessages(messages);
            System.out.println("Deleted: " + deleted);
        } else {
            System.out.println("Invalid index.");
        }
    }
}