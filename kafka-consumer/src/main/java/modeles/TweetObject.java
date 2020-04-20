package modeles;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.Date;


public class TweetObject {

    public TweetObject(){};

    //@JsonProperty("statusId")
    private Long statusId;
    //@JsonProperty("displayName")
    private String displayName;
    //@JsonProperty("Date")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    //@JsonProperty("retweetCount")
    private int retweetCount;
    //@JsonProperty("favoriteCount")
    private int favoriteCount;
    //@JsonProperty("country")
    private String country;
    //@JsonProperty("countryCode")
    private String countryCode;
    //@JsonProperty("source")
    private String source;

    public Long getStatusId() {
        return statusId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Date getDate() {
        return date;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSource() {
        return source;
    }

    public String getTweetText() {
        return tweetText;
    }

    @Override
    public String toString() {
        return "TweetObject{" +
                "statusId=" + statusId +
                ", displayName='" + displayName + '\'' +
                ", date=" + date +
                ", retweetCount=" + retweetCount +
                ", favoriteCount=" + favoriteCount +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", source='" + source + '\'' +
                ", tweetText='" + tweetText + '\'' +
                '}';
    }

    public TweetObject(Long statusId, String displayName, Date date, int retweetCount, int favoriteCount, String country, String countryCode, String source, String tweetText) {
        this.statusId = statusId;
        this.displayName = displayName;
        this.date = date;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.country = country;
        this.countryCode = countryCode;
        this.source = source;
        this.tweetText = tweetText;
    }

    //@JsonProperty("tweetText")
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
