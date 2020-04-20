package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modele.TweetObject;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

import java.util.Map;

public class TwitterSerializer implements Serializer<TweetObject> {
    private Gson gson;
    public void configure(Map<String, ?> map, boolean b) {
        gson = new Gson();
    }

    public byte[] serialize(String topic, TweetObject data) {
        return gson.toJson(data).getBytes();
    }

    public void close() {
        gson = null;
    }
}
