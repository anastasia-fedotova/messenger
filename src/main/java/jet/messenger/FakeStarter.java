package jet.messenger;

import jet.messenger.config.*;

/**
 * FAKE STARTER
 *
 * Simple messaging app based on Apache Kafka API and server.
 * Gets config from config file at the same directory.
 * Works in three modes:
 * -Send message to user
 * -Send broadcast message
 * -Listen to messages
 *
 * @author Evgeny Krutelev
 */
public class FakeStarter {
    public static void main(String[] args) {
        Config config = new ConfigFromJSONFile("config.json").getConfig();
        System.out.println("[SERVER NAME]: " + config.getServerName());

        for (String contact : config.getContactList()){
            System.out.println("[CONTACT]: " + contact);
        }
    }
}
