package jet.messenger;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Sends message to current user or broadcast
 *
 * @author Evgeny Krutelev
 */
public class MessageSender{
    private User user;
    private Message message;

    MessageSender(User user, Message message){
        this.user = user;
        this.message = message;
    }

    public void sendMessage(){
        Producer<String, String> producer = getProducer();
        producer.send(new ProducerRecord<String, String>(message.getRecieverUserId(), message.getMessageBody()));
        producer.close();
    }

    public void broadcast(){
        Producer<String, String> producer = getProducer();
        for (String receiverName : user.getUserList()){
            producer.send(new ProducerRecord<String, String>(receiverName, message.getMessageBody()));
        }
        producer.close();
    }

    /**
     *Creates Kafka Producer object to interact with Kafka server
     */
    private Producer getProducer (){
        Properties props = new Properties();
        props.put("bootstrap.servers", "bvm163.lpr.jet.msk.su:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer<String, String>(props);

    }
}
