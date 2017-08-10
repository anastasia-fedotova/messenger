package jet.messenger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Simple messaging app based on Apache Kafka API and server.
 * Gets config from config file at the same directory.
 * Works in three modes:
 * -Send message to user
 * -Send broadcast message
 * -Listen to messages
 *
 * @author Evgeny Krutelev
 */
public class MessengerApp {
    public static void main(String[] args) {
        String[] config = loadConfigFromFile();
        User user;

        if (config.length > 1){
            user = new User(config[0], config[1].split(" "), config[2], config[3], Integer.parseInt(config[4]));
        } else {
            user = new User();
        }

        ArgsParser parser = new ArgsParser(args, user);
        parser.executeCommands();
    }

    public static String[] loadConfigFromFile(){
        try{
            String configFile = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/" + "config")));
            String[] config = configFile.split("\n");
            return config;
        }catch (IOException e){
            System.out.println("Configurable file not found.");
        }
        return new String[]{""};
    }
}
