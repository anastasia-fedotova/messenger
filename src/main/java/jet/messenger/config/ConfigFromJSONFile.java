package jet.messenger.config;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *Creates messengers config object from JSON file.
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

public class ConfigFromJSONFile {
    private String filepath;

    public ConfigFromJSONFile(String filepath) {
        this.filepath = filepath;
    }

    public Config getConfig(){
        return loadConfigFromJSONFile(filepath);
    }

    /**
     * Gets config from JSON file
     */
    private Config loadConfigFromJSONFile(String filepath){
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(filepath));
            JSONObject jsonObject = (JSONObject) obj;

            String userId = (String) jsonObject.get("userId");
            String topic = (String) jsonObject.get("topic");
            String serverName = (String) jsonObject.get("serverName");
            String serverPort = (String) jsonObject.get("serverPort");

            JSONArray jsonContactList = (JSONArray) jsonObject.get("contactList");
            List<String> contactList = new ArrayList<>();
            for (Object contact : jsonContactList) {
                contactList.add(contact.toString());
            }

            return new Config(userId, contactList, topic, serverName, serverPort);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
