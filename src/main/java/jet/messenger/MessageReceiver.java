package jet.messenger;

import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * Gets messages from Kafka server
 *
 * @author Evgeny Krutelev
 */
public class MessageReceiver {
    private User user;

    MessageReceiver(User user){
        this.user = user;
    }

    public void getMessages(){
        String topic = user.getTopic();
        String group = "group";
        Properties props = new Properties();
        props.put("bootstrap.servers", user.getServerName() + ":" + user.getServerPort());
        props.put("group.id", group);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.println(record.value());
        }
    }

    public void getMessagesForTest(){
        String topic = user.getTopic();
        String group = "group";
        Properties props = new Properties();
        props.put("bootstrap.servers", user.getServerName() + ":" + user.getServerPort());
        props.put("group.id", group);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList(topic));

        for (int i=0; i < 10; i++) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.println(record.value());
        }
    }
}
