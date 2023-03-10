import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.RandomAccess;

public class KafkaSimpleProducer {
    public static void main(String[] args) {

        // localIp:port or dockerIp:port
        String bootstrapServer = "localhost:9092";

        //cluster ip:port
        String topic = "topic-test";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());


        KafkaProducer<String, String> producer= new KafkaProducer<>(properties);
        ProducerRecord<String, String>  record = new ProducerRecord<>(topic, new Date() +" - hello_world_message");


        producer.send(record).isDone();
        System.out.println("message was sent with success!!");
        producer.flush();
        producer.close();

    }
}