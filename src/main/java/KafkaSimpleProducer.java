import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaSimpleProducer {
    public static void main(String[] args) {

        //cluster ip:port
        String bootstrapServer = "172.21.122.239:9092";
        String topic = "topic-test";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());



        KafkaProducer<String, String> producer= new KafkaProducer<>(properties);
        ProducerRecord<String, String>  record = new ProducerRecord<>(topic,"hello_world_message");


        producer.send(record);
        producer.flush();
        producer.close();

    }
}