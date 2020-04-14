package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.util.Properties;

public class TwitterConfig {

    private static Logger logger = LoggerFactory.getLogger(TwitterConfig.class);
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;

    private TwitterConfig(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }


    private static TwitterConfig configuration;
    public static TwitterConfig getInstance(){
        logger.info("Trying to initialize config.");
        if(configuration == null ){
            YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
            yamlPropertiesFactoryBean.setResources(new ClassPathResource("application.yml"));
            Properties properties = yamlPropertiesFactoryBean.getObject();
            configuration = new TwitterConfig(properties.getProperty("twitter.consumerKey"),properties.getProperty("twitter.consumerSecret"),
                    properties.getProperty("twitter.accessToken"),properties.getProperty("twitter.accessTokenSecret"));
            logger.info(" Successfully initialized config with values: {}",properties);
        }return configuration;

    }

    public static Logger getLogger() {
        return logger;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }






}
