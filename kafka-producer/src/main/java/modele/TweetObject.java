package modele;

import java.util.Date;

public class TweetObject {

    private Long statusId;
    private String displayName;
    private Date date;
    private int retweetCount;
    private int favoriteCount;
    private String country;
    private String countryCode;
    private String source;
    private String tweetText;


    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
}
