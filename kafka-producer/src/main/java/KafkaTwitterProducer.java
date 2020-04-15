import config.TwitterConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaTwitterProducer {


    private static final Logger logger = LoggerFactory.getLogger(KafkaTwitterProducer.class);
    public static final int NUM_TWEETS = 2000;
    private final Object lock = new Object();

    public static void main(String args[]) {
    //    public List<Status> execute() {

        Properties kafkaProperties = new Properties();
        kafkaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop000:9092");
        kafkaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        kafkaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        kafkaProperties.put(ProducerConfig.ACKS_CONFIG, "all");
        final Producer kafkaProducer = new KafkaProducer(kafkaProperties);

            logger.info("Build Connection");
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setJSONStoreEnabled(true);
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(TwitterConfig.getInstance().getConsumerKey())
                    .setOAuthConsumerSecret(TwitterConfig.getInstance().getConsumerSecret())
                    .setOAuthAccessToken(TwitterConfig.getInstance().getAccessToken())
                    .setOAuthAccessTokenSecret(TwitterConfig.getInstance().getAccessTokenSecret());

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
                .getInstance(); // First you create the Stream
        final List<Status> statuses = new ArrayList<Status>();
        StatusListener listener = new StatusListener() {
            public void onException(Exception e) {
                e.printStackTrace();
            }
            public void onStatus(Status status) {
                statuses.add(status);
                ProducerRecord data = new ProducerRecord("twitterData", DataObjectFactory.getRawJSON(status));
                kafkaProducer.send(data);
                System.out.println("@ ---- "+status.getUser().getScreenName()+"-------"+"----------"+status.getText());

            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }
            public void onStallWarning(StallWarning stallWarning) {
            }
        };
        String[] keywords = {"#coronavirus"};
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track(keywords);
        twitterStream.addListener(listener);
        twitterStream.filter(filterQuery);

        logger.info("Starting the twitter stream.");






        }


    }


