import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String args[])
    {
//    {
//        String topicName = "SimpleProducerTopic";
//        String key = "Key1";
//        String value = "Value1";
//
//        Properties props = new Properties();
//        props.put("bootstrap.servers","localhost:9092,localhost:9093");
//        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        String topicName = "SimpleProducerTopic";
        String key = "Key1";
        String value = "Value1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9093");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String,String> producer = new KafkaProducer<String, String>(props);
        for(int i=0;i<5;i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
            producer.send(record);

        }

        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}
