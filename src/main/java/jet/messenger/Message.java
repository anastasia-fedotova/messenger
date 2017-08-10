package jet.messenger;

/**
 * Message contents message fields
 *
 * @author Evgeny Krutelev
 */
public class Message {
    private String recieverUserId;
    private String messageBody;

    Message(String recieverUserId, String messageBody){
        this.recieverUserId = recieverUserId;
        this.messageBody = messageBody;
    }

    Message(){
        this.recieverUserId = "test";
        this.messageBody = "Message sending is working!";
    }

    public String getRecieverUserId() {
        return recieverUserId;
    }

    public void setRecieverUserId(String recieverUserId) {
        this.recieverUserId = recieverUserId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
