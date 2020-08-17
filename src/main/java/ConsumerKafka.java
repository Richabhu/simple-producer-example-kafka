import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;


import java.util.Arrays;
import java.util.Properties;

public class ConsumerKafka {
    public static void main(String args[]) {


        String topicName = "SimpleProducerTopic";
        String key = "Key1";
        String value = "Value1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9093");
//        props.put("group.id", "1");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));
        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d , key=%s, value = %s", record.offset(), record.key(), record.value());
                }
            }
        }
        finally {
            consumer.close();
        }

    }
}
