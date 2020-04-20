package utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import modele.TweetObject;
import org.apache.kafka.common.serialization.Serializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import java.util.Map;

public class TwitterSerializer implements Serializer<TweetObject> {
    private Gson gson;
    public void configure(Map<String, ?> map, boolean b) {
        gson = new Gson();
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
