package utils;


import modele.TweetObject;
import twitter4j.Status;

public class TwitterUtils {



    public static TweetObject parseStatus(Status status){
        TweetObject tweetObject = new TweetObject();
        tweetObject.setStatusId(status.getId());
        tweetObject.setDisplayName(status.getUser().getScreenName());

        tweetObject.setDate(status.getCreatedAt());
        tweetObject.setRetweetCount(status.getRetweetCount());
        tweetObject.setFavoriteCount(status.getFavoriteCount());
        if(status.getPlace()!=null) {
            tweetObject.setCountry(status.getPlace().getCountry());
            tweetObject.setCountryCode(status.getPlace().getCountryCode());
        }
        tweetObject.setSource(status.getSource());
        tweetObject.setTweetText(status.getText());

        return tweetObject;

    }



}
