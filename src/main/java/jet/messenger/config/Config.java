package jet.messenger.config;


import java.util.List;

/**
 *Stores messengers configuration.
 *
 * Stores:
 * -userId
 * -contactList
 * -topic
 * -serverName
 * -serverPort
 *
 * @author Evgeny Krutelev
 */

public class Config {
    private String userId;
    private List<String> contactList;
    private String topic;
    private String serverName;
    private String serverPort;

    public Config(String userId, List<String> contactList, String topic, String serverName, String serverPort) {
        this.userId = userId;
        this.contactList = contactList;
        this.topic = topic;
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    /**
     * Messenger User ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Users contacts list
     */
    public List<String> getContactList() {
        return contactList;
    }

    /**
     * Kafka topic name
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Kafka server name
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Kafka server port
     */
    public String getServerPort() {
        return serverPort;
    }
}
