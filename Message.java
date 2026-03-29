public class Message {
  
    String messageText;
    String recipientNumber;
    int messageId;

    public Message(String messageText, String recipientNumber, int messageId) {
        this.messageText = messageText;
        this.recipientNumber = recipientNumber;
        this.messageId = messageId;
    }
}
