package jet.messenger;

/**
 * Contains user information
 *
 * @author Evgeny Krutelev
 */
public class User {
    private String userID;
    private String[] userList;
    private String topic;
    private String serverName;
    private int serverPort;

    User (String userID, String[] userList, String topic, String serverName, int serverPort){
        this.userID = userID;
        this.userList = userList;
        this.topic = topic;
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    User (){
        this.userID = "defaultUser1";
        this.userList = new String[]{"test", "test1"};
        this.topic = "test";
        this.serverName = "bvm163.lpr.jet.msk.su";
        this.serverPort = 9092;
    }

    public String getUserID() {
        return userID;
    }

    public String[] getUserList() {
        return userList;
    }

    public String getTopic() {
        return topic;
    }

    public String getServerName() {
        return serverName;
    }

    public int getServerPort() {
        return serverPort;
    }
}
