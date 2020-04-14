import config.TwitterConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Properties;

public class KafkaTwitterProducer {


    private static final Logger logger = LoggerFactory.getLogger(KafkaTwitterProducer.class);




    public void start () {
            logger.info("Build Connection");
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(TwitterConfig.getInstance().getConsumerKey())
                    .setOAuthConsumerSecret(TwitterConfig.getInstance().getConsumerSecret())
                    .setOAuthAccessToken(TwitterConfig.getInstance().getAccessToken())
                    .setOAuthAccessTokenSecret(TwitterConfig.getInstance().getAccessTokenSecret());

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            logger.info("Connection Réussie");

            Properties kafkaProperties = new Properties();
            kafkaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:8082");
            kafkaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                    StringSerializer.class.getName());
            kafkaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                    StringSerializer.class.getName());
            kafkaProperties.put(ProducerConfig.ACKS_CONFIG, "all");
            final Producer kafkaProducer = new KafkaProducer(kafkaProperties);





        }



    }

