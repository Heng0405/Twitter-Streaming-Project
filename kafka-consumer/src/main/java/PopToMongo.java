import com.fasterxml.jackson.databind.ObjectMapper;

import modeles.TweetObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.json4s.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;
import utils.TwitterDeserializer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PopToMongo {
    private static final Logger logger = LoggerFactory.getLogger(PopToMongo.class);

    public static void main(String args[]){
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("PopToMongo");
        JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Durations.seconds(2));
        //TwitterDeserializer twitterDeserializer = new TwitterDeserializer();

        Map<String, Object> kafkaParams = new HashMap<String, Object>();
        kafkaParams.put("bootstrap.servers", "hadoop000:9092");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", TwitterDeserializer.class);
        kafkaParams.put("group.id", "POPTOMONGO-Direct-Stream-PRO-v1");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);

        Collection<String> topics = Arrays.asList("twitterData");

        logger.info("Start Stream");
        JavaInputDStream<ConsumerRecord<String, String>> stream =
                KafkaUtils.createDirectStream(
                        streamingContext,
                        LocationStrategies.PreferConsistent(),
                        ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
                );
        JavaDStream<Object> streamObject = stream.map(record-> record.value());

        logger.info("Test print les objects-------------------------------------------------------");
        streamObject.foreachRDD(rdd ->{
            System.out.println("--- New RDD with " + rdd.partitions().size()
                    + " partitions and " + rdd.count() + " records");
            rdd.collect().forEach(ele -> System.out.println(ele.toString()));
        });


        // Start the computation
        streamingContext.start();
        try {
            streamingContext.awaitTermination();
            logger.info("Stop the job");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
