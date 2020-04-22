package utils;



import com.fasterxml.jackson.databind.ObjectMapper;
import modeles.TweetObject;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class TwitterDeserializer implements Deserializer<TweetObject>{

     private ObjectMapper objectMapper;

     private static final Logger logger = LoggerFactory.getLogger(TwitterDeserializer.class);

    @Override
    public void configure(Map map, boolean b) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public TweetObject deserialize(String s, byte[] bytes) {
        TweetObject tweetObject = null;

        try {
            logger.info("自定义的反序列化-deserialize");
            tweetObject = objectMapper.readValue(bytes,TweetObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tweetObject ;
    }


    @Override
    public void close() {
        objectMapper = null;
    }

}
