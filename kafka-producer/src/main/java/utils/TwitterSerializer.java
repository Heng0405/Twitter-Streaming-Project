package utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import modele.TweetObject;
import org.apache.kafka.common.serialization.Serializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

public class TwitterSerializer implements Serializer<TweetObject> {

    private ObjectMapper objectMapper;

    public void configure(Map<String, ?> configs, boolean isKey) {
        objectMapper = new ObjectMapper();
        DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        objectMapper.setDateFormat(myDateFormat);
    }

    public byte[] serialize(String topic, TweetObject data) {
        byte[] objectSerialise = null;
        try {
            objectSerialise =  objectMapper.writeValueAsString(data).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }return objectSerialise;
    }

    public void close() {
        objectMapper = null;
    }



}
